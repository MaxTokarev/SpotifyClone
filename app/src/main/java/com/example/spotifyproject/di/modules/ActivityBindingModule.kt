package com.example.spotifyproject.di.modules

import com.example.presentation.ui.SplashFragment
import com.example.spotifyproject.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

}