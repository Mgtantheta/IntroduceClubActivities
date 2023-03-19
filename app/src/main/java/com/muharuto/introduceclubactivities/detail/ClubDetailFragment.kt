package com.muharuto.introduceclubactivities.detail

import CarouselPictureController
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muharuto.introduceclubactivities.ClubSummaryApplication
import com.muharuto.introduceclubactivities.R
import com.muharuto.introduceclubactivities.data.HomeClubSummary
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryData
import com.muharuto.introduceclubactivities.databinding.FragmentClubDetailBinding

class ClubDetailFragment : Fragment(R.layout.fragment_club_detail) {
    private val args: ClubDetailFragmentArgs by navArgs()

    private var _binding: FragmentClubDetailBinding? = null
    private val binding get() = _binding!!

    private val carouselController = CarouselPictureController()

    private val viewModel: ClubViewModel by activityViewModels {
        ClubViewModelFactory(
            (activity?.application as ClubSummaryApplication).database.clubSummaryDao()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentClubDetailBinding.bind(view)

        setupRecyclerView()
        observeClubData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            setController(carouselController)
        }
    }

    private fun observeClubData() {
        val clubId = args.clubId
        viewModel.retrieveClub(clubId).observe(viewLifecycleOwner) { clubData ->
            bindClubData(clubData)
            setCarouselData(clubData)
        }
    }

    private fun bindClubData(clubData: ClubSummaryData) {
        binding.apply {
            clubName.text = clubData.clubName
            clubSentence.text = clubData.clubSentence
            clubActivityDay.text = clubData.clubActivityDay
            activityPlace.text = clubData.activityPlace
            clubRepresentatives.text = clubData.clubRepresentative
            clubRepresentativeId.text = clubData.clubRepresentativeId
        }
    }

    private fun setCarouselData(clubData: ClubSummaryData) {
        val baseId = clubData.id
        val homeClubSummaryList = List(5) { index ->
            HomeClubSummary(
                id = baseId * 1000 + index,
                image = clubData.clubImage,
                name = "",
                representative = "",
                sentence = "",
                activityDayOfWeek = "",
                place = "",
                representativeId = ""
            )
        }
        carouselController.setData(homeClubSummaryList)
    }

}
