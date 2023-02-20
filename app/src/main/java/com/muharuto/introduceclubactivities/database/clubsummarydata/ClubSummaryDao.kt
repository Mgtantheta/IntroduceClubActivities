package com.muharuto.introduceclubactivities.database.clubsummarydata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ClubSummaryDao {
    @Query("SELECT * FROM clubSummaryData")
    fun getAll(): LiveData<List<ClubSummaryData>>

    @Insert
    fun insert(clubSummaryData: ClubSummaryData)
}
