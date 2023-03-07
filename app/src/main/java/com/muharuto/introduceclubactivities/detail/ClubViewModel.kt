package com.muharuto.introduceclubactivities.detail

import androidx.lifecycle.*
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

