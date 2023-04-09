package com.muharuto.introduceclubactivities.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.muharuto.introduceclubactivities.ClubSummaryApplication
import com.muharuto.introduceclubactivities.R
import com.muharuto.introduceclubactivities.databinding.FragmentHomeBinding
import com.muharuto.introduceclubactivities.detail.ClubViewModel
import com.muharuto.introduceclubactivities.detail.ClubViewModelFactory

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var fragmentHomeBinding: FragmentHomeBinding? = null

    private val clubViewModel by activityViewModels<ClubViewModel> {
        ClubViewModelFactory(
            (activity?.application as ClubSummaryApplication).database.clubSummaryDao()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        fragmentHomeBinding = binding
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val listener = object : ClubAdapter.OnItemClickListener {
            override fun onItemClick(id: Int) {
                val action = HomeFragmentDirections.actionHomeFragmentToClubDetailFragment(id)
                findNavController().navigate(action)
            }
        }
        clubViewModel.clubSummaryList.observe(viewLifecycleOwner) {
            binding.recyclerView.adapter = ClubAdapter(requireContext(), it, listener)
        }

        binding.addClubInfoButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addClubSummaryFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentHomeBinding = null
    }
}
