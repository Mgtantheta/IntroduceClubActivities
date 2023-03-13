package com.muharuto.introduceclubactivities.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muharuto.introduceclubactivities.ClubSummaryApplication
import com.muharuto.introduceclubactivities.R
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryData
import com.muharuto.introduceclubactivities.databinding.FragmentClubDetailBinding

class ClubDetailFragment : Fragment(R.layout.fragment_club_detail) {

    private var _binding: FragmentClubDetailBinding? = null
    private val binding get() = _binding!!

    lateinit var clubSummaryData: ClubSummaryData

    private val viewModel: ClubViewModel by activityViewModels {
        ClubViewModelFactory(
            (activity?.application as ClubSummaryApplication).database.clubSummaryDao()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentClubDetailBinding.bind(view)
        _binding = binding
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CarouselPictureController()
        binding.recyclerView.apply {
            setController(adapter)
            layoutManager = LinearLayoutManager(
                requireContext(), RecyclerView.VERTICAL, false
            )
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bind(clubSummaryData: ClubSummaryData) {
        binding.apply {
            binding.clubName.text = clubSummaryData.clubName
            binding.clubSentence.text = clubSummaryData.clubSentence
            binding.clubActivityDay.text = clubSummaryData.clubActivityDay
            binding.activityPlace.text = clubSummaryData.activityPlace
            binding.clubRepresentatives.text = clubSummaryData.clubRepresentative
            binding.clubRepresentativeId.text = clubSummaryData.clubRepresentativeId
        }
    }
}
