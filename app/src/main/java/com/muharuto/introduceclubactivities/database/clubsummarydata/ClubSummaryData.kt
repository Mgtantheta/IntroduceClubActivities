package com.muharuto.introduceclubactivities.database.clubsummarydata

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "clubSummaryDB")
data class ClubSummaryData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    // 実装できたら後で写真は追加する
    // @NotNull @DrawableRes @ColumnInfo("club_image") val clubImage: Int,
    @NotNull @ColumnInfo("club_name") val clubName: String,
    @NotNull @ColumnInfo("club_representative") val clubRepresentative: String,
    @NotNull @ColumnInfo("club_sentence") val clubSentence: String,
    @NotNull @ColumnInfo("club_activity_day") val clubActivityDay: String,
    @NotNull @ColumnInfo("activity_place") val activityPlace: String,
    @NotNull @ColumnInfo("club_representative_id") val clubRepresentativeId: String
)
