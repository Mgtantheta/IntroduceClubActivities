package com.muharuto.introduceclubactivities.database.clubsummarydata

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "clubSummaryData")
data class ClubSummaryData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @NotNull @ColumnInfo("club_image") val clubImage: ByteArray,
    @NotNull @ColumnInfo("club_name") val clubName: String,
    @NotNull @ColumnInfo("club_representative") val clubRepresentative: String,
    @NotNull @ColumnInfo("club_sentence") val clubSentence: String,
    @NotNull @ColumnInfo("club_activity_day") val clubActivityDay: String,
    @NotNull @ColumnInfo("activity_place") val activityPlace: String,
    @NotNull @ColumnInfo("club_representative_id") val clubRepresentativeId: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ClubSummaryData

        if (id != other.id) return false
        if (!clubImage.contentEquals(other.clubImage)) return false
        if (clubName != other.clubName) return false
        if (clubRepresentative != other.clubRepresentative) return false
        if (clubSentence != other.clubSentence) return false
        if (clubActivityDay != other.clubActivityDay) return false
        if (activityPlace != other.activityPlace) return false
        if (clubRepresentativeId != other.clubRepresentativeId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + clubImage.contentHashCode()
        result = 31 * result + clubName.hashCode()
        result = 31 * result + clubRepresentative.hashCode()
        result = 31 * result + clubSentence.hashCode()
        result = 31 * result + clubActivityDay.hashCode()
        result = 31 * result + activityPlace.hashCode()
        result = 31 * result + clubRepresentativeId.hashCode()
        return result
    }
}
