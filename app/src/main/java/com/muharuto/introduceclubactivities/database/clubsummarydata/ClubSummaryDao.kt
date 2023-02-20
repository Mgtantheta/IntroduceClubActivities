package com.muharuto.introduceclubactivities.database.clubsummarydata

import androidx.annotation.DrawableRes
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ClubSummaryDao {
    @Query("SELECT * FROM clubSummaryDB")
    fun getAll(): MutableLiveData<List<ClubSummaryData>>

    @Insert
    fun insert(
        @DrawableRes club_image: Int,
        club_representative: String,
        club_sentence: String,
        activityDayOfWeek: String,
        club_representative_id: String
    )
}
