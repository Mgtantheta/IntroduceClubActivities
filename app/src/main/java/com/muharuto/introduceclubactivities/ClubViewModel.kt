package com.muharuto.introduceclubactivities

import androidx.lifecycle.*
import com.muharuto.introduceclubactivities.data.ActivityDayOfWeek
import com.muharuto.introduceclubactivities.data.ClubSummary
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryDao

class ClubViewModel(private val clubSummaryDao: ClubSummaryDao) : ViewModel() {
    //Mutableは書き換えられるから書き換えられないようにする
    private val _clubSummaryList = MutableLiveData<List<ClubSummary>>()
    val clubSummaryList: LiveData<List<ClubSummary>> = _clubSummaryList

//  fun fullClubSummary(): List<ClubSummary> = clubSummaryDao.getAll()

    init {
        _clubSummaryList.value = listOf(
            ClubSummary(
                id = 1,
                image = R.drawable.sample,
                name = "クライミング",
                representative = "村木春友",
                sentence = "金曜の18時からやってます！壁登ります！",
                activityDayOfWeek = listOf(ActivityDayOfWeek.FRIDAY),
                representativeId = "g031t156"
            )
        )
    }
// FIXME: 後で消す
//    fun addClubSummary() {
//         _clubSummaryList.value = _clubSummaryList.value?.plus(
//            ClubSummary(
//                id = 1,
//                image = R.drawable.sample,
//                name = "クライミング",
//                activityDayOfWeek = listOf(ActivityDayOfWeek.FRIDAY)
//            )
//        )
//    }
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

