package com.muharuto.introduceclubactivities

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter

class BindingAdapters {
    @BindingAdapter("bitmapSrc")
    fun ImageView.setBitmapSrc(bitmap: Bitmap?) {
        setImageBitmap(bitmap)
    }
}
