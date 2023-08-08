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

    /**
     * Fetches all clubs sorted by club name.
     */
    @Query("SELECT * FROM clubSummaryData ORDER BY club_name")
    fun fetchClubs(): LiveData<List<ClubSummaryData>>

    /**
     * Retrieves a specific club by its ID.
     */
    @Query("SELECT * FROM clubSummaryData WHERE id = :id")
    fun getClub(id: Int): Flow<ClubSummaryData>

    /**
     * Inserts a new club entry. Ignores if duplicate.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(clubSummaryData: ClubSummaryData)

    /**
     * Updates an existing club entry.
     */
    @Update
    suspend fun update(clubSummaryData: ClubSummaryData)

    /**
     * Deletes a specific club entry.
     */
    @Delete
    suspend fun delete(clubSummaryData: ClubSummaryData)
}
