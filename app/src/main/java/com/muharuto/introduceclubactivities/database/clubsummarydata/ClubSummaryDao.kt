package com.muharuto.introduceclubactivities.database.clubsummarydata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ClubSummaryDao {

    @Query("SELECT * FROM clubSummaryData ORDER BY club_name")
    fun fetchClubs(): LiveData<List<ClubSummaryData>>

    @Query("SELECT * FROM clubSummaryData WHERE id = :id")
    fun getClub(id: Int): Flow<ClubSummaryData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(clubSummaryData: ClubSummaryData)

    @Update
    suspend fun update(clubSummaryData: ClubSummaryData)

    @Delete
    suspend fun delete(clubSummaryData: ClubSummaryData)
}
