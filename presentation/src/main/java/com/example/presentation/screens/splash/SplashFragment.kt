package com.example.presentation.screens.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.presentation.R
import com.example.presentation.databinding.FragmentSplashBinding
import com.example.presentation.helpers.injectViewModel
import com.example.presentation.helpers.viewBinding
import com.example.presentation.screens.splash.models.SplashAction
import com.example.presentation.screens.splash.models.SplashEvent
import com.example.presentation.screens.splash.models.SplashStatus
import com.example.presentation.screens.splash.models.SplashViewState
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::bind)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: SplashViewModel
    private lateinit var router: SplashRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)

        router = SplashRouter(this)
        Handler(Looper.getMainLooper()).postDelayed({
            router.routeToMain()
        }, 2200)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = injectViewModel(factory = viewModelFactory)
        viewModel.viewStates().observe(viewLifecycleOwner, (this::bindViewState))
        viewModel.viewEffects().observe(viewLifecycleOwner, (this::bindViewAction))
        viewModel.obtainEvent(SplashEvent.ScreenShown)

        viewModel.setName("YEP")

    }

    private fun bindViewState(viewState: SplashViewState) {
        when (viewState.status) {
            SplashStatus.CheckAuthorization -> {

            }
        }
    }

    private fun bindViewAction(viewAction: SplashAction) {
    }
}
