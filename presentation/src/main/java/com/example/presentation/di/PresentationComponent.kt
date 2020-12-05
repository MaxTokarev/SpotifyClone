package com.example.presentation.di

import com.example.domain.di.DomainComponent
import com.example.utils.di.UtilsComponent
import dagger.Component

@Component(dependencies = [DomainComponent::class, UtilsComponent::class])
@PresentationScope
interface PresentationComponent {

    @Component.Builder
    interface Builder {

        fun domainComponent(domainComponent: DomainComponent): Builder
        fun utilsComponent(utilsComponent: UtilsComponent): Builder

        fun build(): PresentationComponent
    }
}