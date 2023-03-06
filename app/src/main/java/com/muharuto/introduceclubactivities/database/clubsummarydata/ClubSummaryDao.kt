package com.muharuto.introduceclubactivities.database.clubsummarydata

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface ClubSummaryDao {

    @Query("SELECT * FROM clubSummaryDB ORDER BY club_name")
    fun getItems(): Flow<List<ClubSummaryData>>

    @Query("SELECT * FROM clubSummaryDB WHERE id = :id")
    fun getClub(id: Int): Flow<ClubSummaryData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(clubSummaryData: ClubSummaryData)

    @Update
    suspend fun update(clubSummaryData: ClubSummaryData)

    @Delete
    suspend fun delete(clubSummaryData: ClubSummaryData)

    // TODO: UpdateとDeleteを後で作成
}
