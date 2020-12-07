package com.example.spotifyproject

import android.app.Application
import com.example.data.di.DaggerDataComponent
import com.example.data.di.DataComponent
import com.example.domain.di.DaggerDomainComponent
import com.example.domain.di.DomainComponent
import com.example.presentation.di.DaggerPresentationComponent
import com.example.presentation.di.PresentationComponent
import com.example.spotifyproject.di.DaggerAppComponent
import com.example.utils.di.DaggerUtilsComponent
import com.example.utils.di.UtilsComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class SpotifyApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        val appComponent = DaggerAppComponent.builder()
            .application(this)
            .presentationComponent(providePresentationComponent())
            .utilsComponent(provideUtilsComponent())
            .domainComponent(provideDomainComponent())
            .dataComponent(provideDataComponent())
            .build()

        appComponent.inject(this)
    }

    private fun providePresentationComponent(): PresentationComponent {
        return DaggerPresentationComponent.builder()
            .domainComponent(provideDomainComponent())
            .utilsComponent(provideUtilsComponent())
            .build()
    }

    private fun provideUtilsComponent(): UtilsComponent {
        return DaggerUtilsComponent.builder()
            .application(this)
            .build()
    }

    private fun provideDomainComponent(): DomainComponent {
        return DaggerDomainComponent.builder()
            .build()
    }

    private fun provideDataComponent(): DataComponent {
        return DaggerDataComponent.builder()
            .build()
    }

}