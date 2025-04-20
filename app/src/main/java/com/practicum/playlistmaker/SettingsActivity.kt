package com.practicum.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
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
        val contractButton = findViewById<RelativeLayout>(R.id.settings_contract_button)

        contractButton.setOnClickListener {
            val contractIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.offerta_link)))
            startActivity(contractIntent)
        }

        supportButton.setOnClickListener {
            val supportIntent =  Intent(Intent.ACTION_SEND_MULTIPLE).apply {
                putExtra(Intent.EXTRA_EMAIL, arrayOf( getString(R.string.my_email)))
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject_to_support))
                putExtra(Intent.EXTRA_TEXT, getString(R.string.message_to_support))

            }
            startActivity(Intent.createChooser(supportIntent, "Выберите email приложение"))
        }

        shareButton.setOnClickListener {
            val message = "https://practicum.yandex.ru/android-developer"
            val shareIntent = Intent(Intent.ACTION_SEND).apply { type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, message)
            }
            startActivity(Intent.createChooser(shareIntent, "Поделиться"))
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
            finish()
        }

    }
}