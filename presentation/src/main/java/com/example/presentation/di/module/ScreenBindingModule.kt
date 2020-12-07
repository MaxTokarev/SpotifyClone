package com.example.presentation.di.module

import com.example.domain.di.modules.UseCasesModule
import com.example.presentation.screens.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [UseCasesModule::class])
abstract class ScreenBindingModule {

    @ContributesAndroidInjector
    abstract fun splashFragment(): SplashFragment

}