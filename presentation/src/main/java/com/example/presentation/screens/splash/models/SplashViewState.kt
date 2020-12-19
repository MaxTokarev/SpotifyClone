package com.example.presentation.screens.splash.models

data class SplashViewState(
    val status: SplashStatus
)

sealed class SplashStatus {
    object CheckAuthorization : SplashStatus()
    data class Success(val status: AuthorizationStatus) : SplashStatus()
}

enum class AuthorizationStatus {
    AUTH,
    TO_AUTH
}
