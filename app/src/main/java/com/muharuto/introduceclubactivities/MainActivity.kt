package com.muharuto.introduceclubactivities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentTransaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_view, HomeFragment())
            .addToBackStack(null)
        fragmentTransaction.commit()
    }
}
