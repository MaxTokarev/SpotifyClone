package com.example.presentation.screens.login.models

import com.example.presentation.screens.main.home.models.BaseModelImpl

data class LoginViewState(
    val fetchStatus: FetchStatus,
    val data: List<BaseModelImpl>
)

sealed class FetchStatus {
    object Success : FetchStatus()
    data class ShowError(val message: String) : FetchStatus()
    object Loading : FetchStatus()
}
