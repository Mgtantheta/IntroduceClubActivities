package com.muharuto.introduceclubactivities.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryData
import com.muharuto.introduceclubactivities.databinding.ClubSummaryItemBinding

class ClubAdapter(
    private val context: Context,
    private val dataset: List<ClubSummaryData>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ClubViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ClubViewHolder = ClubViewHolder(
        ClubSummaryItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(
        holder: ClubViewHolder, position: Int
    ) {
        val item = dataset[position]
        holder.bind(item, context, listener)
    }

    override fun getItemCount() = dataset.size

    interface OnItemClickListener {
        fun onItemClick(id: Int)
    }
}
