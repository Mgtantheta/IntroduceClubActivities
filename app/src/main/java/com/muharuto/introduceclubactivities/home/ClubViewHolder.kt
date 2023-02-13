package com.muharuto.introduceclubactivities.home

import android.content.Context
import android.graphics.BitmapFactory
import androidx.recyclerview.widget.RecyclerView
import com.muharuto.introduceclubactivities.data.ClubSummary
import com.muharuto.introduceclubactivities.databinding.ClubSummaryItemBinding

class ClubViewHolder(private val binding: ClubSummaryItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(clubSummary: ClubSummary, context: Context, onItemClickListener: ClubAdapter.OnItemClickListener) {
        binding.clubImage.setImageBitmap(BitmapFactory.decodeResource(context.resources, clubSummary.image))
        binding.clubName.text = clubSummary.name
        binding.activityDayOfWeek.text = clubSummary.activityDayOfWeek.joinToString(",") {
            it.name
        }
        binding.root.setOnClickListener {
            onItemClickListener.onItemClick()
        }
    }
}
