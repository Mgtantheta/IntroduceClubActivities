package com.muharuto.introduceclubactivities.database.clubsummarydata

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clubSummaryDB")
data class ClubSummaryData(
    @PrimaryKey(autoGenerate = true) val id: Int,
    //写真
    @DrawableRes val club_image: Int,
    //クラブの名前
    val club_name: String?,
    //代表者
    val club_representative: String?,
    //クラブの説明文
    val club_sentence: String?,
    //list<ActivityDayOfWeek>型だがStringでおいておく
    val activityDayOfWeek: String?,
    //g031t156みたいな値
    val club_representative_id: String?
)
