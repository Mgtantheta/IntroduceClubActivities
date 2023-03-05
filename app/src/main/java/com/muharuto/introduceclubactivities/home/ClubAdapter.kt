package com.muharuto.introduceclubactivities.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muharuto.introduceclubactivities.data.ClubSummary
import com.muharuto.introduceclubactivities.databinding.ClubSummaryItemBinding

class ClubAdapter(
    private val context: Context,
    private val dataset: List<ClubSummary>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ClubViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClubViewHolder = ClubViewHolder(
        ClubSummaryItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    //ViewHolderにデータの紐付け
    override fun onBindViewHolder(
        holder: ClubViewHolder, position: Int
    ) {
        val item = dataset[position]
        holder.bind(item, context, listener)
    }

    //リストの長さを返す
    override fun getItemCount() = dataset.size

    //interface clickListenerを実装
    interface OnItemClickListener {
        fun onItemClick()
    }
}
