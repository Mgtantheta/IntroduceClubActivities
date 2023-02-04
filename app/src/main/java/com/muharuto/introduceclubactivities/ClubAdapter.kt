package com.muharuto.introduceclubactivities

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ClubAdapter(private val dataset: List<ClubSummary>) : RecyclerView.Adapter<ClubViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClubViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.club_summary_item, parent, false)
        return ClubViewHolder(view)
    }

    //ViewHolderにデータの紐付け
    override fun onBindViewHolder(
        holder: ClubViewHolder,
        position: Int
    ) {
        val item = dataset[position]
        holder.clubNameView.text = item.name
        holder.clubImageView.setImageBitmap(item.image)
        holder.clubActivityDayOfWeekView.text = item.activityDayOfWeek.joinToString(",") {
            it.name
        }
    }

    //リストの長さを返す
    override fun getItemCount() = dataset.size
}