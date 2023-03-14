package com.muharuto.introduceclubactivities.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.muharuto.introduceclubactivities.R
import com.muharuto.introduceclubactivities.data.ActivityDayOfWeek
import com.muharuto.introduceclubactivities.data.HomeClubSummary
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryDao
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClubViewModel(private val clubSummaryDao: ClubSummaryDao) : ViewModel() {
    private val _clubSummaryList = MutableLiveData<List<HomeClubSummary>>()
    val clubSummaryList: LiveData<List<HomeClubSummary>> = _clubSummaryList

    init {
        getAllClubs()
    }

    private fun insertClub(clubSummaryData: ClubSummaryData) {
        viewModelScope.launch {
            clubSummaryDao.insert(clubSummaryData)
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

    private fun getAllClubs() {
        viewModelScope.launch(Dispatchers.IO) {
            _clubSummaryList.postValue(clubSummaryDao.fetchClubs().map {
                HomeClubSummary(
                    id = it.id,
                    image = R.drawable.sample,
                    name = it.clubName,
                    representative = it.clubRepresentative,
                    sentence = it.clubSentence,
                    activityDayOfWeek = listOf(
                        ActivityDayOfWeek.FRIDAY, ActivityDayOfWeek.SUNDAY
                    ),
                    place = it.activityPlace,
                    representativeId = it.clubRepresentativeId
                )
            })
        }
    }

    fun retrieveClub(id: Int): LiveData<ClubSummaryData> {
        return clubSummaryDao.getClub(id).asLiveData()
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

