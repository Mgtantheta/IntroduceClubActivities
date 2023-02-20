package com.muharuto.introduceclubactivities

import androidx.lifecycle.*
import com.muharuto.introduceclubactivities.data.ActivityDayOfWeek
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryDao
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryData

class ClubViewModel(private val clubSummaryDao: ClubSummaryDao) : ViewModel() {
    //Mutableは書き換えられるから書き換えられないようにする
    private val _clubSummaryList = MutableLiveData<List<ClubSummaryData>>()
    val clubSummaryList: LiveData<List<ClubSummaryData>> = _clubSummaryList

  fun fullClubSummary(): LiveData<List<ClubSummaryData>> = clubSummaryDao.getAll()

    init {
        _clubSummaryList.value = listOf(
            ClubSummaryData(
                id = 1,
                club_image = R.drawable.sample,
                club_name = "クライミング",
                club_representative = "村木春友",
                club_sentence = "金曜の18時からやってます！壁登ります！",
                activityDayOfWeek = listOf(ActivityDayOfWeek.FRIDAY).joinToString(separator = ","),
                club_representative_id = "g031t156"
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
            @Suppress("UNCHECKED_CAST")
            return ClubViewModel(clubSummaryDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

