package com.muharuto.introduceclubactivities

import android.app.Application
import com.muharuto.introduceclubactivities.database.AppDatabase

class ClubSummaryApplication: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}
