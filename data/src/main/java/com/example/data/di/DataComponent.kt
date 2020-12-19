package com.example.data.di

import android.app.Application
import com.example.data.di.modules.DatabaseModule
import com.example.data.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component

@Component(modules = [NetworkModule::class, DatabaseModule::class])
@DataScope
interface DataComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): DataComponent
    }
}