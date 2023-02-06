package com.muharuto.introduceclubactivities

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.muharuto.introduceclubactivities.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var fragmentHomeBinding: FragmentHomeBinding? = null

    private val clubViewModel by viewModels<ClubViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        fragmentHomeBinding = binding
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        clubViewModel.clubSummaryList.observe(viewLifecycleOwner) {
            binding.recyclerView.adapter = ClubAdapter(requireContext(), it)
        }

        binding.addClubInfoButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addClubSummaryFragment)
        }
    }

    override fun onDestroyView() {
        fragmentHomeBinding = null
        super.onDestroyView()
    }
}
