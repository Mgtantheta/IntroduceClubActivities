package com.muharuto.introduceclubactivities

import android.graphics.Bitmap


data class ClubSummary(val id: Int, val image: Bitmap, val name: String, val activityDayOfWeek: List<ActivityDayOfWeek>)
