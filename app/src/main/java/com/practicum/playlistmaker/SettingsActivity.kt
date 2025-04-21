package com.practicum.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textview.MaterialTextView

class SettingsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backButton = findViewById<MaterialToolbar>(R.id.top_settings_toolbar)
        val shareButton = findViewById<MaterialTextView>(R.id.settings_button_share)
        val supportButton = findViewById<MaterialTextView>(R.id.settings_support_button)
        val contractButton = findViewById<MaterialTextView>(R.id.settings_contract_button)
        //val barSearchButton = findViewById<LinearLayout>(R.id.bar_search_button)
        //val barMediaButton = findViewById<LinearLayout>(R.id.bar_media_button)

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

        backButton.setNavigationOnClickListener {
            finish()
        }

//        barMediaButton.setOnClickListener {
//            val barMediaIntent = Intent(this, MediaActivity::class.java)
//            startActivity(barMediaIntent)
//            finish()
//        }
//        barSearchButton.setOnClickListener {
//            val barSearchIntent = Intent(this, SearchActivity::class.java)
//            startActivity(barSearchIntent)
//            finish()
//        }

    }
}