package com.example.spotifyproject.di

import android.app.Application
import com.example.data.di.DataComponent
import com.example.domain.di.DomainComponent
import com.example.presentation.di.PresentationComponent
import com.example.presentation.di.ViewModelModule
import com.example.presentation.di.module.ScreenBindingModule
import com.example.spotifyproject.SpotifyApp
import com.example.spotifyproject.di.modules.ActivityBindingModule
import com.example.utils.di.UtilsComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBindingModule::class,
        ScreenBindingModule::class,
        ViewModelModule::class
    ],
    dependencies = [PresentationComponent::class, UtilsComponent::class, DomainComponent::class, DataComponent::class]
)
interface AppComponent : AndroidInjector<SpotifyApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun presentationComponent(presentationComponent: PresentationComponent): Builder
        fun dataComponent(dataComponent: DataComponent): Builder
        fun domainComponent(domainComponent: DomainComponent): Builder
        fun utilsComponent(utilsComponent: UtilsComponent): Builder

        fun build(): AppComponent
    }
}