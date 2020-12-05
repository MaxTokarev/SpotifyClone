package com.example.utils.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [UtilsModule::class]
)
interface UtilsComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): UtilsComponent
    }
}