package com.muharuto.introduceclubactivities.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory

data class HomeClubSummary(
    val id: Int,
    val image: ByteArray,
    val name: String,
    val representative: String,
    val sentence: String,
    val activityDayOfWeek: String,
    val place: String,
    val representativeId: String,
) {
    // ByteArrayのequalsとhashCodeだけをオーバーライド
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HomeClubSummary
        if (!image.contentEquals(other.image)) return false
        return true
    }

    override fun hashCode(): Int {
        return image.contentHashCode()
    }

    fun getImageBitmap(): Bitmap {
        return BitmapFactory.decodeByteArray(image, 0, image.size)
    }
}
