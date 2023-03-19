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

    lateinit var clubSummaryData: ClubSummaryData
    private val carouselController = CarouselPictureController()

    private val viewModel: ClubViewModel by activityViewModels {
        ClubViewModelFactory(
            (activity?.application as ClubSummaryApplication).database.clubSummaryDao()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentClubDetailBinding.bind(view)
        _binding = binding
        val id = args.clubId
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CarouselPictureController()
        binding.recyclerView.setController(carouselController)

        binding.recyclerView.apply {
            setController(adapter)
            layoutManager = LinearLayoutManager(
                requireContext(), RecyclerView.VERTICAL, false
            )
        }
        viewModel.retrieveClub(id).observe(this.viewLifecycleOwner) { selectedClubId ->
            clubSummaryData = selectedClubId
            bind(clubSummaryData)
            val homeClubSummaryList = listOf(
                HomeClubSummary(
                    id = clubSummaryData.id,
                    image = clubSummaryData.clubImage,
                    name = "",
                    representative = "",
                    sentence = "",
                    activityDayOfWeek = "",
                    place = "",
                    representativeId = ""
                )
            )
            carouselController.setData(homeClubSummaryList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bind(clubSummaryData: ClubSummaryData) {
        binding.apply {
            clubName.text = clubSummaryData.clubName
            clubSentence.text = clubSummaryData.clubSentence
            clubActivityDay.text = clubSummaryData.clubActivityDay
            activityPlace.text = clubSummaryData.activityPlace
            clubRepresentatives.text = clubSummaryData.clubRepresentative
            clubRepresentativeId.text = clubSummaryData.clubRepresentativeId
        }
    }

}
