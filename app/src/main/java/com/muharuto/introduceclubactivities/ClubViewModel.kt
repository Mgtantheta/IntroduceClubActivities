package com.muharuto.introduceclubactivities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClubViewModel : ViewModel() {
    //Mutableは書き換えられるから書き換えられないようにする
    private val _clubSummaryList = MutableLiveData<List<ClubSummary>>()
    val clubSummaryList: LiveData<List<ClubSummary>> = _clubSummaryList

    init {
        _clubSummaryList.value = listOf(
            ClubSummary(
                id = 1,
                image = R.drawable.sample,
                name = "クライミング",
                activityDayOfWeek = listOf(ActivityDayOfWeek.FRIDAY, ActivityDayOfWeek.SUNDAY)
            ), ClubSummary(
                id = 2,
                image = R.drawable.sample,
                name = "バドミントン",
                activityDayOfWeek = listOf(ActivityDayOfWeek.MONDAY, ActivityDayOfWeek.TUESDAY)
            ), ClubSummary(
                id = 3,
                image = R.drawable.sample,
                name = "サッカー",
                activityDayOfWeek = listOf(ActivityDayOfWeek.THURSDAY)
            )
        )
    }

    fun addClubSummary() {
         _clubSummaryList.value = _clubSummaryList.value?.plus(
            ClubSummary(
                id = 1,
                image = R.drawable.sample,
                name = "クライミング",
                activityDayOfWeek = listOf(ActivityDayOfWeek.FRIDAY)
            )
        )
    }
}
