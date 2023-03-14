package com.muharuto.introduceclubactivities.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.muharuto.introduceclubactivities.ClubSummaryApplication
import com.muharuto.introduceclubactivities.R
import com.muharuto.introduceclubactivities.databinding.FragementAddClubSummaryBinding
import com.muharuto.introduceclubactivities.detail.ClubViewModel
import com.muharuto.introduceclubactivities.detail.ClubViewModelFactory

class AddClubSummaryFragment : Fragment(R.layout.fragement_add_club_summary) {

    // TODO: 後で使う
    //    lateinit var clubSummaryData: ClubSummaryData

    private var _binding: FragementAddClubSummaryBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ClubViewModel by activityViewModels {
        ClubViewModelFactory(
            (activity?.application as ClubSummaryApplication).database.clubSummaryDao()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragementAddClubSummaryBinding.bind(view)
        _binding = binding

        binding.saveButton.setOnClickListener {
            addNewClub()
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_addClubSummaryFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.clubNameTextBox.text.toString(),
            binding.clubNameTextBox.text.toString(),
            binding.representativeNameTextBox.toString(),
            binding.activityDateCheckbox.toString(),
            binding.activityPlaceTextBox.toString(),
            binding.representativeId.text.toString()
        )
    }

    private fun addNewClub() {
        if (isEntryValid()) {
            viewModel.addNewClub(
                binding.clubNameTextBox.text.toString(),
                binding.representativeNameTextBox.text.toString(),
                binding.clubSentenceTextBox.text.toString(),
                binding.activityDateCheckbox.toString(),
                binding.representativeIdTextBox.text.toString(),
                binding.activityPlaceTextBox.text.toString()
            )
            val action =
                AddClubSummaryFragmentDirections.actionAddClubSummaryFragmentToHomeFragment()
            findNavController().navigate(action)
        }
    }
//TODO: 後で使う
//    private fun bind(clubSummaryData: ClubSummaryData) {
//        binding.apply {
//            clubNameTextBox.setText(clubSummaryData.clubName, TextView.BufferType.SPANNABLE)
//            representativeName.setText(
//                clubSummaryData.clubRepresentative,
//                TextView.BufferType.SPANNABLE
//            )
//            clubSentenceTextBox.setText(clubSummaryData.clubSentence, TextView.BufferType.SPANNABLE)
//            representativeId.setText(
//                clubSummaryData.clubRepresentativeId,
//                TextView.BufferType.SPANNABLE
//            )
//            activityDate.setText(clubSummaryData.clubActivityDay, TextView.BufferType.SPANNABLE)
//            activityPlace.setText(clubSummaryData.activityPlace, TextView.BufferType.SPANNABLE)
//        }
//    }

}
