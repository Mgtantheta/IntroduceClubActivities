package com.muharuto.introduceclubactivities.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryDao
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryData
import kotlinx.coroutines.launch

class ClubViewModel(private val clubSummaryDao: ClubSummaryDao) : ViewModel() {

    private val _clubSummaryList = MutableLiveData<List<ClubSummaryData>>()
    val clubSummaryList: LiveData<List<ClubSummaryData>> = _clubSummaryList

    private val _clubSummary = MutableLiveData<ClubSummaryData>()
    val clubSummary: LiveData<ClubSummaryData> = _clubSummary

    init {
        fetchClubs()
    }

    private fun insertClub(clubSummaryData: ClubSummaryData) {
        viewModelScope.launch {
            clubSummaryDao.insert(clubSummaryData)
            fetchClubs()
        }
    }

    private fun fetchClubs() {
        viewModelScope.launch {
            val clubs = clubSummaryDao.fetchClubs()
            _clubSummaryList.postValue(clubs)
        }
    }

    private fun getNewClubEntry(
        clubName: String,
        clubRepresentative: String,
        clubSentence: String,
        clubActivityDayOfWeek: String,
        representativeId: String,
        activityPlace: String
    ): ClubSummaryData {
        return ClubSummaryData(
            clubName = clubName,
            clubRepresentative = clubRepresentative,
            clubSentence = clubSentence,
            clubActivityDay = clubActivityDayOfWeek,
            clubRepresentativeId = representativeId,
            activityPlace = activityPlace
        )
    }

    fun addNewClub(
        clubName: String,
        clubRepresentative: String,
        clubSentence: String,
        clubActivityDayOfWeek: String,
        representativeId: String,
        activityPlace: String
    ) {
        val newClub = getNewClubEntry(
            clubName,
            clubRepresentative,
            clubSentence,
            clubActivityDayOfWeek,
            representativeId,
            activityPlace
        )
        insertClub(newClub)
    }

    fun isEntryValid(
        clubName: String,
        clubRepresentative: String,
        clubSentence: String,
        clubActivityDayOfWeek: String,
        representativeId: String,
        activityPlace: String
    ): Boolean {
        if (clubName.isBlank() || clubRepresentative.isBlank() || clubSentence.isBlank() || clubActivityDayOfWeek.isBlank() || representativeId.isBlank() || activityPlace.isBlank()) {
            return false
        }
        return true
    }

    fun retrieveClub(id: Int) {
        viewModelScope.launch {
            val club = clubSummaryDao.getClub(id)
            _clubSummary.postValue(club)
        }
    }

}

class ClubViewModelFactory(
    private val clubSummaryDao: ClubSummaryDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClubViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return ClubViewModel(clubSummaryDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

