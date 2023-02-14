package com.muharuto.introduceclubactivities.database.clubsummarydata

import androidx.room.Dao
import androidx.room.Query
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryData

@Dao
interface ClubSummaryDao {
    @Query("SELECT * FROM clubSummary")
    fun getAll(): List<ClubSummaryData>

}
