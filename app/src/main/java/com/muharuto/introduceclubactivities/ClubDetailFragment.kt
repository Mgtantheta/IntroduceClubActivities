package com.muharuto.introduceclubactivities

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muharuto.introduceclubactivities.databinding.FragmentClubDetailBinding

class ClubDetailFragment : Fragment(R.layout.fragment_club_detail) {
    private var fragmentClubDetailBinding: FragmentClubDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentClubDetailBinding.bind(view)
        fragmentClubDetailBinding = binding
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.apply {
            setController(CarouselPictureController())
            layoutManager = LinearLayoutManager(
                requireContext(),
                RecyclerView.HORIZONTAL,
                false
            )
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentClubDetailBinding = null
    }
}
