package com.example.presentation.screens.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.presentation.R
import com.example.presentation.databinding.FragmentLoginBinding
import com.example.presentation.helpers.injectViewModel
import com.example.presentation.helpers.viewBinding
import com.example.presentation.screens.login.models.FetchStatus
import com.example.presentation.screens.login.models.LoginAction
import com.example.presentation.screens.login.models.LoginEvent
import com.example.presentation.screens.login.models.LoginViewState
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class LoginFragment : Fragment(R.layout.fragment_login) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: LoginViewModel
    lateinit var router: LoginRouter

    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)

        router = LoginRouter(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = injectViewModel(factory = viewModelFactory)
        viewModel.viewStates().observe(viewLifecycleOwner, { bindViewState(it) })
        viewModel.viewEffects().observe(viewLifecycleOwner, { bindViewAction(it) })
        viewModel.obtainEvent(LoginEvent.ScreenShown)

        binding.btnLogin.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://accounts.spotify.com/authorize?client_id=efdcb14a73b54b88a1ebdbca2728d936&response_type=code&redirect_uri=https://vemeet.app&scope=user-read-private%20user-read-email&state=34fFs29kd09")
            )
            intent.resolveActivity(requireActivity().packageManager)?.let {
                startActivity(intent)
            }
        }
    }

    private fun bindViewState(viewState: LoginViewState) {
        when (viewState.fetchStatus) {
            FetchStatus.Loading -> Toast.makeText(requireContext(), "LOADING", Toast.LENGTH_SHORT)
                .show()
            FetchStatus.Success -> Toast.makeText(
                requireContext(),
                "${viewState.data}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun bindViewAction(viewAction: LoginAction) {
        when (viewAction) {
            is LoginAction.ShowSnackbar ->
                Toast.makeText(context, viewAction.message, Toast.LENGTH_SHORT).show()
        }
    }
}