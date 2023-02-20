package com.muharuto.introduceclubactivities.database.clubsummarydata

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.muharuto.introduceclubactivities.data.ActivityDayOfWeek

@Entity
data class ClubSummaryData(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @DrawableRes val club_image: Int,
    val club_name: String,
    val club_representative: String,
    val club_sentence: String,
    val activityDay: List<ActivityDayOfWeek>,
    val club_representative_id: String
)
