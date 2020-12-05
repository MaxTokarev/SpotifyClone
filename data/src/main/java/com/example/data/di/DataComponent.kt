package com.example.data.di

import dagger.Component

@Component
@DataScope
interface DataComponent {

    @Component.Builder
    interface Builder {

        fun build(): DataComponent
    }
}