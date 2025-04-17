package com.practicum.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backButton = findViewById<ImageButton>(R.id.settings_back_button)
        val barSearchButton = findViewById<LinearLayout>(R.id.bar_search_button)
        val barMediaButton = findViewById<LinearLayout>(R.id.bar_media_button)
        val shareButton = findViewById<RelativeLayout>(R.id.settings_button_share)
        val supportButton = findViewById<RelativeLayout>(R.id.settings_support_button)

        supportButton.setOnClickListener {
            val message = "Привет Android это круто"
            val shareIntent = Intent(Intent.ACTION_SENDTO)
            shareIntent.data = Uri.parse("mailto:")
            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("kolesnikov.yk@ya.ru"))
            shareIntent.putExtra(Intent.EXTRA_EMAIL, message)
            startActivity(shareIntent)
        }

        shareButton.setOnClickListener {
            val message = "https://practicum.yandex.ru/android-developer"
            val shareIntent = Intent(Intent.ACTION_SEND).apply { type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, message)
            }
            startActivity(shareIntent)
        }

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