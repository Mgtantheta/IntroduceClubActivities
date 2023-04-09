package com.muharuto.introduceclubactivities.data

import androidx.annotation.DrawableRes


data class HomeClubSummary(
    val id: Int,
    @DrawableRes val image: Int,
    val name: String,
    val representative: String,
    val sentence: String,
    val activityDayOfWeek: List<ActivityDayOfWeek>,
    val place: String,
    val representativeId: String,
)
