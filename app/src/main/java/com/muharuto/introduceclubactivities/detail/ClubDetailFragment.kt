package com.muharuto.introduceclubactivities.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muharuto.introduceclubactivities.R
import com.muharuto.introduceclubactivities.databinding.FragmentClubDetailBinding

class ClubDetailFragment : Fragment(R.layout.fragment_club_detail) {
    private var fragmentClubDetailBinding: FragmentClubDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentClubDetailBinding.bind(view)
        fragmentClubDetailBinding = binding
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CarouselPictureController()
//        adapter.setData(
//            listOf(
//                ClubSummary(
//                    id = 1,
//                    image = R.drawable.sample,
//                    name = "東北Tech道場・盛岡道場",
//                    representative = "g031t071",
//                    activityDayOfWeek = listOf(ActivityDayOfWeek.SUNDAY),
//                    sentence = "日曜日に活動してます",
//                    representativeId = "佐藤佑哉"
//                )
//            )
//        )
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
