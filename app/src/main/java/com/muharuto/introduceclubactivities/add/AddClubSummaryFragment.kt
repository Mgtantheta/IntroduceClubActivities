package com.muharuto.introduceclubactivities.add

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.muharuto.introduceclubactivities.ClubSummaryApplication
import com.muharuto.introduceclubactivities.R
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryData
import com.muharuto.introduceclubactivities.databinding.FragementAddClubSummaryBinding
import com.muharuto.introduceclubactivities.detail.ClubViewModel
import com.muharuto.introduceclubactivities.detail.ClubViewModelFactory

class AddClubSummaryFragment : Fragment(R.layout.fragement_add_club_summary) {

    private val navigationArgs: AddClubSummaryFragmentArgs by navArgs()
    lateinit var clubSummaryData: ClubSummaryData


    private var _fragmentAddClubSummaryBinding: FragementAddClubSummaryBinding? = null
    private val fragmentAddClubSummaryBinding get() = _fragmentAddClubSummaryBinding!!

    private val viewModel: ClubViewModel by activityViewModels {
        ClubViewModelFactory(
            (activity?.application as ClubSummaryApplication).database.clubSummaryDao()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragementAddClubSummaryBinding.bind(view)
        _fragmentAddClubSummaryBinding = binding

//        val id = navigationArgs.clubId
//        if (id > 0) {
//            viewModel.retrieveItem(id).observe(this.viewLifecycleOwner) { selectedClub ->
//                clubSummaryData = selectedClub
//                bind(clubSummaryData)
//            }
//        } else {
//            binding.saveButton.setOnClickListener {
//                addNewClub()
//            }
//        }

        binding.saveButton.setOnClickListener {
            addNewClub()
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_addClubSummaryFragment_to_homeFragment)
        }
    }

    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            fragmentAddClubSummaryBinding.clubNameTextBox.text.toString(),
            fragmentAddClubSummaryBinding.clubNameTextBox.text.toString(),
            fragmentAddClubSummaryBinding.representativeNameTextBox.toString(),
            fragmentAddClubSummaryBinding.activityDateCheckbox.toString(),
            fragmentAddClubSummaryBinding.activityPlaceTextBox.toString(),
            fragmentAddClubSummaryBinding.representativeId.text.toString()
        )
    }

    private fun addNewClub() {
        if (isEntryValid()) {
            viewModel.addNewClub(
                fragmentAddClubSummaryBinding.clubNameTextBox.text.toString(),
                fragmentAddClubSummaryBinding.representativeNameTextBox.text.toString(),
                fragmentAddClubSummaryBinding.clubSentenceTextBox.text.toString(),
                fragmentAddClubSummaryBinding.activityDateCheckbox.toString(),
                fragmentAddClubSummaryBinding.representativeIdTextBox.text.toString(),
                fragmentAddClubSummaryBinding.activityPlaceTextBox.text.toString()
            )
            val action =
                AddClubSummaryFragmentDirections.actionAddClubSummaryFragmentToHomeFragment()
            findNavController().navigate(action)
        }
    }

    private fun bind(clubSummaryData: ClubSummaryData) {
        fragmentAddClubSummaryBinding.apply {
            clubNameTextBox.setText(clubSummaryData.clubName, TextView.BufferType.SPANNABLE)
            representativeName.setText(
                clubSummaryData.clubRepresentative,
                TextView.BufferType.SPANNABLE
            )
            clubSentenceTextBox.setText(clubSummaryData.clubSentence, TextView.BufferType.SPANNABLE)
            representativeId.setText(
                clubSummaryData.clubRepresentativeId,
                TextView.BufferType.SPANNABLE
            )
            activityDate.setText(clubSummaryData.clubActivityDay, TextView.BufferType.SPANNABLE)
            activityPlace.setText(clubSummaryData.activityPlace, TextView.BufferType.SPANNABLE)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentAddClubSummaryBinding = null
    }
}
