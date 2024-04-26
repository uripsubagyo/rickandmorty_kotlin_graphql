package com.example.rickandmortyapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import com.example.rickandmortyapi.ui.MainHomeActivity
import com.example.rickandmortyapi.ui.ui.TestActivity
import com.example.rickandmortyapi.ui.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.button_start)
        btnStart.setOnClickListener{
            val toMainScreen = Intent(this@MainActivity,MainHomeActivity::class.java)
            startActivity(toMainScreen)
        }
    }

}