package com.muharuto.introduceclubactivities.home

import android.content.Context
import android.graphics.BitmapFactory
import androidx.recyclerview.widget.RecyclerView
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryData
import com.muharuto.introduceclubactivities.databinding.ClubSummaryItemBinding

class ClubViewHolder(private val binding: ClubSummaryItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(
        clubSummaryData: ClubSummaryData,
        context: Context,
        onItemClickListener: ClubAdapter.OnItemClickListener
    ) {
        binding.clubImage.setImageBitmap(
            BitmapFactory.decodeByteArray(
                clubSummaryData.clubImage,
                0,
                clubSummaryData.clubImage.size
            )
        )
        binding.clubName.text = clubSummaryData.clubName
        binding.activityDayOfWeek.text = clubSummaryData.clubActivityDay
        binding.root.setOnClickListener {
            onItemClickListener.onItemClick(id = clubSummaryData.id)
        }
    }
}
