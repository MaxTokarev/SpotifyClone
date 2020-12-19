package com.example.presentation.screens.login

import com.example.presentation.screens.base.BaseViewModel
import com.example.presentation.screens.login.models.FetchStatus
import com.example.presentation.screens.login.models.LoginAction
import com.example.presentation.screens.login.models.LoginEvent
import com.example.presentation.screens.login.models.LoginViewState
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class LoginViewModel @Inject constructor() :
    BaseViewModel<LoginViewState, LoginAction, LoginEvent>() {

    private val compositeDisposable = CompositeDisposable()

    init {
        viewState = LoginViewState(fetchStatus = FetchStatus.Loading, data = emptyList())
    }

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            LoginEvent.ScreenShown -> init()
        }
    }

    private fun init() {

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}