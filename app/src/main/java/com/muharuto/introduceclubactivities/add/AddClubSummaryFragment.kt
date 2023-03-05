package com.muharuto.introduceclubactivities.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.muharuto.introduceclubactivities.R
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryData
import com.muharuto.introduceclubactivities.databinding.FragementAddClubSummaryBinding

class AddClubSummaryFragment : Fragment(R.layout.fragement_add_club_summary) {
    private var fragmentAddClubSummaryBinding: FragementAddClubSummaryBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragementAddClubSummaryBinding.bind(view)
        fragmentAddClubSummaryBinding = binding

        binding.saveButton.setOnClickListener {
            findNavController().navigate(R.id.action_addClubSummaryFragment_to_homeFragment)
            val clubSummaryData = ClubSummaryData(
                id = 1,
                clubImage = R.drawable.sample,
                clubName = "バドミントン",
                clubRepresentative = "hogehoge",
                clubSentence = "バドミントンは楽しいですよ",
                activityDayOfWeek = "月",
                clubRepresentativeId = "g031t999"
            )

//            ClubSummaryApplication().database.clubSummaryDao().insert(
//                clubSummaryData
//            )
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_addClubSummaryFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentAddClubSummaryBinding = null
    }
}
