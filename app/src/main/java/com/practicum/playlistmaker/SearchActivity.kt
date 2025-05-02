package com.practicum.playlistmaker

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.google.android.material.appbar.MaterialToolbar


class SearchActivity : AppCompatActivity() {

    private var searchTextInput: String = AMOUNT_DEF

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(PRODUCT_AMOUNT, searchTextInput)
    }

    companion object {
        const val PRODUCT_AMOUNT = "PRODUCT_AMOUNT"
        const val AMOUNT_DEF = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val recycler = findViewById<RecyclerView>(R.id.test_recycler)
        recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val trackAdapter = TrackAdapter(Track.trackList)
        recycler.adapter = trackAdapter




        val backButton = findViewById<MaterialToolbar>(R.id.top_search_toolbar)
        val searchEditText = findViewById<EditText>(R.id.search_edit_text)
        val clearButton = findViewById<ImageButton>(R.id.clear_text_button)

        if (savedInstanceState != null) {
            searchTextInput = savedInstanceState.getString(PRODUCT_AMOUNT, AMOUNT_DEF)
            searchEditText.setText(searchTextInput)
        }

        backButton.setNavigationOnClickListener {
            finish()
        }

        val searchTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (s != null) {
                    searchTextInput = s.toString()
                } else { searchTextInput = AMOUNT_DEF }
                // searchTextInput = s?.toString() ?: AMOUNT_DEF
                clearButton.isVisible = !s.isNullOrEmpty()
            }

        }
        searchEditText.addTextChangedListener(searchTextWatcher)

        clearButton.setOnClickListener{
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            searchEditText.text.clear()
            inputMethodManager?.hideSoftInputFromWindow(searchEditText.windowToken, 0)
            searchEditText.clearFocus()
        }
    }
}