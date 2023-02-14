package com.muharuto.introduceclubactivities.database.clubsummarydata

import androidx.annotation.DrawableRes
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.muharuto.introduceclubactivities.data.ActivityDayOfWeek

@Entity
data class ClubSummaryData(
    @PrimaryKey val id: Int,
    @ColumnInfo @DrawableRes val image: Int,
    @ColumnInfo(name = "club_name") val name: String,
    @ColumnInfo(name = "activity_day_of_week") val activityDayOfWeek: List<ActivityDayOfWeek>
)
