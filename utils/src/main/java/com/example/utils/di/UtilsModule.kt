package com.example.utils.di

import android.app.Application
import android.content.Context
import com.example.utilities.resources.IResourcesProvider
import com.example.utils.resources.ResourcesProvider
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class UtilsModule {
    @Binds
    abstract fun bindContext(application: Application): Context

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun bindResourceProvider(context: Context): IResourcesProvider {
            return ResourcesProvider(context)
        }
    }
}