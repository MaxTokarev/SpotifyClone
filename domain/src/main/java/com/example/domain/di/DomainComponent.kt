package com.example.domain.di

import com.example.data.di.DataComponent
import com.example.domain.di.modules.UseCasesModule
import dagger.Component

@Component(modules = [UseCasesModule::class])
@DomainScope
interface DomainComponent {

    @Component.Builder
    interface Builder {
        fun build(): DomainComponent
    }
}