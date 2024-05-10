package com.example.rickandmortyapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.rickandmortyapi.present.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.button_start)
        btnStart.setOnClickListener{
            val toMainScreen = Intent(this@MainActivity,HomeActivity::class.java)
            startActivity(toMainScreen)
        }
    }

}