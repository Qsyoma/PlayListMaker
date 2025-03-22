package com.practicum.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backButton = findViewById<ImageButton>(R.id.settings_back_button)
        val barSearchButton = findViewById<LinearLayout>(R.id.bar_search_button)
        val barMediaButton = findViewById<LinearLayout>(R.id.bar_media_button)

        barMediaButton.setOnClickListener {
            val barMediaIntent = Intent(this, MediaActivity::class.java)
            startActivity(barMediaIntent)
            finish()
        }
        barSearchButton.setOnClickListener {
            val barSearchIntent = Intent(this, SearchActivity::class.java)
            startActivity(barSearchIntent)
            finish()
        }
        backButton.setOnClickListener {
            val backIntent = Intent(this, MainActivity::class.java)
            startActivity(backIntent)
            finish()
        }
    }
}