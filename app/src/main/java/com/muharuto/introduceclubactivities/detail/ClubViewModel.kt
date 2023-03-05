package com.muharuto.introduceclubactivities.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muharuto.introduceclubactivities.R
import com.muharuto.introduceclubactivities.data.ActivityDayOfWeek
import com.muharuto.introduceclubactivities.data.ClubSummary
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryDao

class ClubViewModel(private val clubSummaryDao: ClubSummaryDao) : ViewModel() {
    private val _clubSummaryList = MutableLiveData<List<ClubSummary>>()
    val clubSummaryList: LiveData<List<ClubSummary>> = _clubSummaryList

    init {
        _clubSummaryList.value = listOf(
            ClubSummary(
                id = 1,
                image = R.drawable.sample,
                name = "東北テック道場",
                representative = "佐藤佑哉",
                sentence = "日曜日やってます！",
                activityDayOfWeek = listOf(ActivityDayOfWeek.SUNDAY),
                representativeId = "g031t999"
            )
        )
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

