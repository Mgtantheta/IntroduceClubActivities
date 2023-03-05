package com.muharuto.introduceclubactivities.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryDao
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryData

@Database(entities = [ClubSummaryData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun clubSummaryDao(): ClubSummaryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .createFromAsset("database/club_summary_database.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}