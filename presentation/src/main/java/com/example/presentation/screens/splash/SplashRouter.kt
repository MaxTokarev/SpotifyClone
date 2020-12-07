package com.example.presentation.screens.splash

import androidx.navigation.fragment.findNavController
import com.example.presentation.R

interface SplashRoutingLogic {
    fun routeToMain()
    fun routeToLogIn()
}

class SplashRouter(val fragment: SplashFragment) : SplashRoutingLogic{

    override fun routeToMain() {
        fragment
            .findNavController()
            .navigate(R.id.action_splashFragment_to_mainFragment)
    }

    override fun routeToLogIn() {
        fragment
            .findNavController()
            .navigate(R.id.action_splashFragment_to_loginFragment)
    }

}