package com.example.presentation.screens.login.models

sealed class LoginAction {
    data class ShowSnackbar(val message: String) : LoginAction()
}
