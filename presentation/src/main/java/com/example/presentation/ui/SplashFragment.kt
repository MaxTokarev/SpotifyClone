package com.example.presentation.ui

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import com.example.presentation.R
import com.example.presentation.databinding.FragmentSplashBinding
import com.example.presentation.helpers.viewBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SplashFragment : Fragment(R.layout.fragment_splash) {

    @Inject
    lateinit var string: String
    private val binding by viewBinding(FragmentSplashBinding::bind)

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.tvShit.text = string
        }, 1000)
    }
}
