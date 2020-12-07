package com.example.presentation.screens.main

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil.bind
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.presentation.R
import com.example.presentation.databinding.FragmentMainBinding
import com.example.presentation.helpers.viewBinding


class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.navHostMain) as NavHostFragment

        NavigationUI
            .setupWithNavController(binding.bottomNavigationView, navHostFragment.navController)
    }
}