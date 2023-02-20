package com.muharuto.introduceclubactivities.data

import androidx.annotation.DrawableRes

data class ClubSummary(
    val id: Int,
    @DrawableRes val image: Int,
    val club_name: String,
    val activityDayOfWeek: List<ActivityDayOfWeek>,
)
