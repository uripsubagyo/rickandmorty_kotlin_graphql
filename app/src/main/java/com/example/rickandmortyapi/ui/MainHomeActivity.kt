package com.example.rickandmortyapi.ui

import com.example.rickandmortyapi.R
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.rickandmortyapi.databinding.ActivityMainHomeBinding
import com.example.rickandmortyapi.ui.ui.home.HomeFragment
import com.example.rickandmortyapi.ui.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainHomeBinding
    val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main_home)

        navView.setupWithNavController(navController)
    }
}