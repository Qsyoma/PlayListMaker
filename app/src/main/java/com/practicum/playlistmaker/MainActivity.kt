package com.practicum.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settingsButton = findViewById<Button>(R.id.main_button_settings)

     settingsButton.setOnClickListener {
         val settingsIntent = Intent(this, SettingsActivity::class.java)
         startActivity(settingsIntent)
     }
    }
}