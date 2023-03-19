package com.muharuto.introduceclubactivities

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.muharuto.introduceclubactivities.data.HomeClubSummary

@BindingAdapter("bitmapSrc")
fun ImageView.setBitmapSrc(homeClubSummary: HomeClubSummary?) {
    if (homeClubSummary != null) {
        val bitmap = homeClubSummary.getImageBitmap()
        setImageBitmap(bitmap)
    } else {
        setImageResource(android.R.color.transparent)
    }
}
