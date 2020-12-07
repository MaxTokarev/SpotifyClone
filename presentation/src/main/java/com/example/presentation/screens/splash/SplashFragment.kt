package com.example.presentation.screens.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import com.example.presentation.R
import com.example.presentation.databinding.FragmentSplashBinding
import com.example.presentation.helpers.viewBinding
import com.example.presentation.screens.login.LoginFragment
import dagger.android.support.AndroidSupportInjection

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::bind)

    private lateinit var router: SplashRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)

        router = SplashRouter(this)
        Handler(Looper.getMainLooper()).postDelayed({
            router.routeToMain()
        },2200)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
