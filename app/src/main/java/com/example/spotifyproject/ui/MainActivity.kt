package com.example.spotifyproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.spotifyproject.R
import com.example.spotifyproject.di.AppComponent
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}