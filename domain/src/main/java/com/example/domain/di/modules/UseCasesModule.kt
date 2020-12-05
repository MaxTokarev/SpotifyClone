package com.example.domain.di.modules

import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun provideString():String{
        return "SHIT"
    }

}