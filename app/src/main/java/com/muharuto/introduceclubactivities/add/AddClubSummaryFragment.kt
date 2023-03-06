package com.muharuto.introduceclubactivities.add

import android.os.Bundle
import android.view.View
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

    private var _fragmentAddClubSummaryBinding: FragementAddClubSummaryBinding? = null
    private val fragmentAddClubSummaryBinding get() = _fragmentAddClubSummaryBinding!!

    lateinit var clubSummaryData: ClubSummaryData


    private val viewModel: ClubViewModel by activityViewModels {
        ClubViewModelFactory(
            (activity?.application as ClubSummaryApplication).database.clubSummaryDao()
        )
    }

    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            fragmentAddClubSummaryBinding.clubNameTextBox.text.toString(),
            fragmentAddClubSummaryBinding.clubNameTextBox.text.toString(),
            fragmentAddClubSummaryBinding.representativeNameTextBox.toString(),
            fragmentAddClubSummaryBinding.activityDateCheckbox.toString(),
            fragmentAddClubSummaryBinding.activityPlaceTextBox.toString(),
            fragmentAddClubSummaryBinding.representativeId.toString()
        )
    }

    private fun addNewClub() {
        if (isEntryValid()) {
            viewModel.addNewClub(
                fragmentAddClubSummaryBinding.clubNameTextBox.text.toString(),
                fragmentAddClubSummaryBinding.clubNameTextBox.text.toString(),
                fragmentAddClubSummaryBinding.representativeNameTextBox.toString(),
                fragmentAddClubSummaryBinding.activityDateCheckbox.toString(),
                fragmentAddClubSummaryBinding.activityPlaceTextBox.toString(),
                fragmentAddClubSummaryBinding.representativeId.toString()
            )
            val action = AddItemFragmentDirections.actionAddClubSummaryFragmentToHomeFragment()
            findNavController().navigate(action)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragementAddClubSummaryBinding.bind(view)
        _fragmentAddClubSummaryBinding = binding


        binding.saveButton.setOnClickListener {
            addNewClub()
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_addClubSummaryFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentAddClubSummaryBinding = null
    }
}
