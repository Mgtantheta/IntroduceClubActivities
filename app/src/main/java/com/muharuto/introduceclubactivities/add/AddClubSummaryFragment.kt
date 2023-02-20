package com.muharuto.introduceclubactivities.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.muharuto.introduceclubactivities.R
import com.muharuto.introduceclubactivities.databinding.FragementAddClubSummaryBinding

class AddClubSummaryFragment : Fragment(R.layout.fragement_add_club_summary) {
    private var fragmentAddClubSummaryBinding: FragementAddClubSummaryBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragementAddClubSummaryBinding.bind(view)
        fragmentAddClubSummaryBinding = binding
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentAddClubSummaryBinding = null
    }
}
