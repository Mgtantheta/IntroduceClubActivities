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
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HomeClubSummary

        if (id != other.id) return false
        if (!image.contentEquals(other.image)) return false
        if (name != other.name) return false
        if (representative != other.representative) return false
        if (sentence != other.sentence) return false
        if (activityDayOfWeek != other.activityDayOfWeek) return false
        if (place != other.place) return false
        if (representativeId != other.representativeId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + image.contentHashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + representative.hashCode()
        result = 31 * result + sentence.hashCode()
        result = 31 * result + activityDayOfWeek.hashCode()
        result = 31 * result + place.hashCode()
        result = 31 * result + representativeId.hashCode()
        return result
    }

    fun getImageBitmap(): Bitmap? {
        return BitmapFactory.decodeByteArray(image, 0, image.size)
    }
}
