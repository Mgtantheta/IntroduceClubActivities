package com.muharuto.introduceclubactivities.database.clubsummarydata

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ClubSummaryDao {
    @Query("SELECT * FROM clubSummaryDB")
    fun getAll(): List<ClubSummaryData>
}
