package com.example.presentation.screens.splash

import android.content.SharedPreferences
import com.example.presentation.screens.base.BaseViewModel
import com.example.presentation.screens.splash.models.SplashAction
import com.example.presentation.screens.splash.models.SplashEvent
import com.example.presentation.screens.splash.models.SplashViewState
import javax.inject.Inject

class SplashViewModel @Inject constructor(private val sharedPreferences: SharedPreferences) :
    BaseViewModel<SplashViewState, SplashAction, SplashEvent>() {


    fun setName(name: String) {
        sharedPreferences.edit().putString("name", name).apply()
    }

    override fun obtainEvent(viewEvent: SplashEvent) {
    }
}