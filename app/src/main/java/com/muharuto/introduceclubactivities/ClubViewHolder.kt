package com.muharuto.introduceclubactivities

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClubViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    val clubImageView: ImageView = view.findViewById(R.id.clubImage)
    val clubNameView: TextView = view.findViewById(R.id.clubName)
    val clubActivityDayOfWeekView: TextView = view.findViewById(R.id.activityDayOfWeek)
}
