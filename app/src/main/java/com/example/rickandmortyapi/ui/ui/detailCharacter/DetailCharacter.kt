package com.example.rickandmortyapi.ui.ui.detailCharacter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.graphics.blue
import androidx.lifecycle.*
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.ActivityDetailCharacterBinding
import com.example.rickandmortyapi.domain.model.Character
import com.example.rickandmortyapi.domain.use_case.character.GetCharacterUseCase
import com.example.rickandmortyapi.domain.use_case.character.GetCharactersUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailCharacter : AppCompatActivity() {

    private val detaiCharacterViewMode : DetailCharacterViewModel by viewModels()

    private lateinit var binding : ActivityDetailCharacterBinding

    private lateinit var getCharacterUseCase: GetCharacterUseCase

    companion object {
        const val ID = "id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_character)

//        binding = ActivityDetailCharacterBinding.inflate(layoutInflater)


        detaiCharacterViewMode.getDetailCharacter(idCharacter = intent.getStringExtra(ID).toString())

        Log.d("CHECK_ID", intent.getStringExtra(ID).toString())
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                detaiCharacterViewMode.dataDetailCharacter.collectLatest {
                    Log.d("RESULT_DATA_CHARACTER", it.detailCharacter.toString())
                    resultView(it.detailCharacter)
                }
            }
        }


    }

    private fun resultView(detailView: Character? ){
        val fullName : TextView = findViewById(R.id.name_header)
        fullName.setText(detailView?.name)

        val spesiesName: TextView = findViewById(R.id.species_name)
        spesiesName.setText("Spesies: ${detailView?.species}")

        val statusName: TextView = findViewById(R.id.status)
        statusName.setText("Status: ${detailView?.status}")

        val genderName: TextView = findViewById(R.id.gender)
        genderName.setText("${detailView?.gender}")
        genderName.setTextColor(Color.WHITE)

        if(detailView?.gender == "Male"){
            genderName.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_corner_male))
        }else{
            genderName.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_corner_female))
        }

        val avatarView: ImageView = findViewById(R.id.imageView2)
        Glide.with(this).load(detailView?.image).into(avatarView)
    }
}