package com.muharuto.introduceclubactivities.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.muharuto.introduceclubactivities.R
import com.muharuto.introduceclubactivities.database.AppDatabase
import com.muharuto.introduceclubactivities.database.clubsummarydata.ClubSummaryDao
import com.muharuto.introduceclubactivities.databinding.FragementAddClubSummaryBinding

class AddClubSummaryFragment : Fragment(R.layout.fragement_add_club_summary) {
    private var fragmentAddClubSummaryBinding: FragementAddClubSummaryBinding? = null

    private lateinit var db: AppDatabase
    private lateinit var dao: ClubSummaryDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.db = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java,
            "clubSummary.db"
        ).build()
        this.dao = this.db.clubSummaryDao()
    }

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
