package com.muharuto.introduceclubactivities

import android.graphics.Bitmap
import androidx.annotation.DrawableRes


data class ClubSummary(val id: Int, @DrawableRes val image: Int, val name: String, val activityDayOfWeek: List<ActivityDayOfWeek>)
