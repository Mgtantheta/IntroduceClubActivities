package com.muharuto.introduceclubactivities.database.clubsummarydata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ClubSummaryDao {
    @Query("SELECT * FROM clubSummaryDB")
    fun getAll(): List<ClubSummaryData>

    @Insert
    fun insert(clubSummaryData: ClubSummaryData)

    // TODO: UpdateとDeleteを後で作成
}
