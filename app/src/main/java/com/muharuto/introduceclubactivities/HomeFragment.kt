package com.muharuto.introduceclubactivities

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val mockSummaryList = listOf(
            ClubSummary(
                id = 1,
                image = BitmapFactory.decodeResource(context?.resources, R.drawable.sample),
                name = "クライミング",
                activityDayOfWeek = listOf(ActivityDayOfWeek.FRIDAY, ActivityDayOfWeek.SUNDAY)
            ), ClubSummary(
                id = 2,
                image = BitmapFactory.decodeResource(context?.resources, R.drawable.sample),
                name = "バドミントン",
                activityDayOfWeek = listOf(ActivityDayOfWeek.MONDAY, ActivityDayOfWeek.TUESDAY)
            ), ClubSummary(
                id = 3,
                image = BitmapFactory.decodeResource(context?.resources, R.drawable.sample),
                name = "サッカー",
                activityDayOfWeek = listOf(ActivityDayOfWeek.THURSDAY)
            )
        )
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = ClubAdapter(mockSummaryList)
    }

}
