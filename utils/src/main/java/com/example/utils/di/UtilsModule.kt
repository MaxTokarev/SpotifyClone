package com.example.utils.di

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.utilities.resources.IResourcesProvider
import com.example.utils.resources.ResourcesProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class UtilsModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Module
    @SuppressLint("ModuleCompanionObjects")
    companion object {

        @Provides
        @Singleton
        fun provideSharedPreference(application: Application): SharedPreferences {
            return application.getSharedPreferences("app.db", Context.MODE_PRIVATE)
        }

        @Provides
        @JvmStatic
        fun bindResourceProvider(context: Context): IResourcesProvider {
            return ResourcesProvider(context)
        }
    }
}