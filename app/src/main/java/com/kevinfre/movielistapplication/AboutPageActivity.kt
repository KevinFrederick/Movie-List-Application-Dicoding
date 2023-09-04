package com.kevinfre.movielistapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AboutPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title="About Me"
    }
}