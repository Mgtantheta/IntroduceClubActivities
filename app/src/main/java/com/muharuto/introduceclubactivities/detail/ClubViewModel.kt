package com.muharuto.introduceclubactivities.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryDao
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryData
import kotlinx.coroutines.launch

class ClubViewModel(private val clubSummaryDao: ClubSummaryDao) : ViewModel() {

    val clubSummaryList = clubSummaryDao.fetchClubs()

    private fun insertClub(clubSummaryData: ClubSummaryData) {
        viewModelScope.launch {
            clubSummaryDao.insert(clubSummaryData)
        }
    }

    private fun getNewClubEntry(
        clubImage: ByteArray,
        clubName: String,
        clubRepresentative: String,
        clubSentence: String,
        clubActivityDayOfWeek: String,
        representativeId: String,
        activityPlace: String
    ): ClubSummaryData {
        return ClubSummaryData(
            clubImage = clubImage,
            clubName = clubName,
            clubRepresentative = clubRepresentative,
            clubSentence = clubSentence,
            clubActivityDay = clubActivityDayOfWeek,
            clubRepresentativeId = representativeId,
            activityPlace = activityPlace
        )
    }

    fun addNewClub(
        clubImage: ByteArray,
        clubName: String,
        clubRepresentative: String,
        clubSentence: String,
        clubActivityDayOfWeek: String,
        representativeId: String,
        activityPlace: String
    ) {
        val newClub = getNewClubEntry(
            clubImage = clubImage,
            clubName = clubName,
            clubRepresentative = clubRepresentative,
            clubSentence = clubSentence,
            clubActivityDayOfWeek = clubActivityDayOfWeek,
            representativeId = representativeId,
            activityPlace = activityPlace
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

