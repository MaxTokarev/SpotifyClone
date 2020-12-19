package com.example.utils.di

import android.app.Application
import android.content.SharedPreferences
import com.example.utilities.resources.IResourcesProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [UtilsModule::class]
)
interface UtilsComponent {

    fun getResourceProvider(): IResourcesProvider
    fun getSharedPrefsProvider(): SharedPreferences

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): UtilsComponent
    }
}