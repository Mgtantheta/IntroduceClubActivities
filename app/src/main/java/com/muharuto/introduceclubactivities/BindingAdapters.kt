package com.muharuto.introduceclubactivities

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.muharuto.introduceclubactivities.data.HomeClubSummary

@BindingAdapter("bitmapSrc")
fun ImageView.setBitmapSrc(homeClubSummary: HomeClubSummary?) {
    homeClubSummary?.let {
        setImageBitmap(it.getImageBitmap())
    } ?: setImageResource(android.R.color.transparent)
}
