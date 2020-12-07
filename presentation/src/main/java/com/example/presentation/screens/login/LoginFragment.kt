package com.example.presentation.screens.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.presentation.R
import com.example.presentation.databinding.FragmentLoginBinding
import com.example.presentation.helpers.viewBinding


class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}