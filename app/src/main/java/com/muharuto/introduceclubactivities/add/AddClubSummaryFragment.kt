package com.muharuto.introduceclubactivities.add

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.muharuto.introduceclubactivities.ClubSummaryApplication
import com.muharuto.introduceclubactivities.R
import com.muharuto.introduceclubactivities.databinding.FragementAddClubSummaryBinding
import com.muharuto.introduceclubactivities.detail.ClubViewModel
import com.muharuto.introduceclubactivities.detail.ClubViewModelFactory
import java.io.ByteArrayOutputStream

class AddClubSummaryFragment : Fragment(R.layout.fragement_add_club_summary) {

    private var _binding: FragementAddClubSummaryBinding? = null
    private val binding get() = _binding!!

    private var byteArray: ByteArray? = null

    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode != RESULT_OK) {
            return@registerForActivityResult
        }

        val uri = result.data?.data
        if (uri == null) {
            Toast.makeText(requireContext(), "エラーが発生しました", Toast.LENGTH_LONG).show()
            return@registerForActivityResult
        }

        try {
            val image = readImageFromUri(uri)
            if (image != null) {
                binding.picture1.setImageBitmap(image)
                byteArray = convertBitmapToByteArray(image)
            } else {
                Toast.makeText(requireContext(), "エラーが発生しました", Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "画像の読み込みに失敗しました", Toast.LENGTH_LONG).show()
        }
    }

    private val viewModel: ClubViewModel by activityViewModels {
        ClubViewModelFactory(
            (activity?.applicationContext as ClubSummaryApplication).database.clubSummaryDao()
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

        binding.addPicture.setOnClickListener {
            selectPhoto()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
//    private fun isEntryValid(): Boolean {
//        return viewModel.isEntryValid(
//            clubName = binding.clubNameTextBox.text.toString(),
//            clubRepresentative = binding.representativeNameTextBox.text.toString(),
//            clubSentence = binding.clubSentenceTextBox.text.toString(),
//            clubActivityDayOfWeek = binding.activityDateCheckbox.toString(),
//            representativeId = binding.representativeIdTextBox.text.toString(),
//            activityPlace = binding.activityPlaceTextBox.text.toString()
//        )
//    }

    private fun addNewClub() {
        val byteArray = this.byteArray ?: return Toast.makeText(
            requireContext(), "写真を選択してください", Toast.LENGTH_LONG
        ).show()
        val checkboxes = listOf(
            binding.sun,
            binding.mon,
            binding.tue,
            binding.wed,
            binding.thu,
            binding.fri,
            binding.sat
        )
        viewModel.addNewClub(
            clubImage = byteArray,
            clubName = binding.clubNameTextBox.text.toString(),
            clubRepresentative = binding.representativeNameTextBox.text.toString(),
            clubSentence = binding.clubSentenceTextBox.text.toString(),
            clubActivityDayOfWeek = createSelectedDaysJoinToString(checkboxes),
            representativeId = binding.representativeIdTextBox.text.toString(),
            activityPlace = binding.activityPlaceTextBox.text.toString()
        )
        val action = AddClubSummaryFragmentDirections.actionAddClubSummaryFragmentToHomeFragment()
        findNavController().navigate(action)
    }

    private fun createSelectedDaysJoinToString(checkboxes: List<CheckBox>): String {
        val selectedDays = checkboxes.filter { it.isChecked }.map { it.text.toString() }
        return selectedDays.joinToString(", ")
    }

    private fun readImageFromUri(uri: Uri): Bitmap? {
        return activity?.contentResolver?.openInputStream(uri)?.use {
            BitmapFactory.decodeStream(it)
        }
    }

    private fun convertBitmapToByteArray(bitmap: Bitmap): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        return stream.toByteArray()
    }

    private fun selectPhoto() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "image/*"
        }
        launcher.launch(intent)
    }

}
