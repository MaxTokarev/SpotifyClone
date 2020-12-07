package com.example.presentation.screens.login

import androidx.navigation.fragment.findNavController
import com.example.presentation.R

interface LoginRoutingLogic {
    fun routeToMain()

    fun routeToRegister()
}

class LoginRouter(val fragment: LoginFragment) : LoginRoutingLogic {
    override fun routeToMain() {
        fragment
            .findNavController()
            .navigate(R.id.action_splashFragment_to_mainFragment)
    }

    override fun routeToRegister() {
        TODO("Not yet implemented")
    }

}