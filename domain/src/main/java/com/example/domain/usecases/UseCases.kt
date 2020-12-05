package com.example.domain.usecases

import io.reactivex.rxjava3.core.Single

interface UseCases<T,R> {
    fun execute(request:T): Single<R>
}