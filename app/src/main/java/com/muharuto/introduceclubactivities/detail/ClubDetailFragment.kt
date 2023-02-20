package com.muharuto.introduceclubactivities.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muharuto.introduceclubactivities.R
import com.muharuto.introduceclubactivities.data.ActivityDayOfWeek
import com.muharuto.introduceclubactivities.data.ClubSummary
import com.muharuto.introduceclubactivities.databinding.FragmentClubDetailBinding

class ClubDetailFragment : Fragment(R.layout.fragment_club_detail) {
    private var fragmentClubDetailBinding: FragmentClubDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentClubDetailBinding.bind(view)
        fragmentClubDetailBinding = binding
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CarouselPictureController()
        adapter.setData(
            listOf(
                ClubSummary(
                    id = 1,
                    image = R.drawable.sample,
                    name = "東北Tech道場・盛岡道場",
                    activityDayOfWeek = listOf(ActivityDayOfWeek.SUNDAY)
                ), ClubSummary(
                    id = 2,
                    image = R.drawable.sample,
                    name = "バドミントン",
                    activityDayOfWeek = listOf(ActivityDayOfWeek.MONDAY, ActivityDayOfWeek.TUESDAY)
                ), ClubSummary(
                    id = 3,
                    image = R.drawable.sample,
                    name = "サッカー",
                    activityDayOfWeek = listOf(ActivityDayOfWeek.THURSDAY)
                )
            )
        )
        binding.recyclerView.apply {
            setController(adapter)
            layoutManager = LinearLayoutManager(
                requireContext(), RecyclerView.VERTICAL, false
            )
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentClubDetailBinding = null
    }
}
