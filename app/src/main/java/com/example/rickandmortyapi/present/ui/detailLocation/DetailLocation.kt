package com.example.rickandmortyapi.present.ui.detailLocation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.ActivityDetailLocationBinding
import com.example.rickandmortyapi.present.ui.detailLocation.Adapter.CharacterIconAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class DetailLocation : AppCompatActivity(){

    private val detailLocationViewModel: DetailLocationViewModel by viewModels()

    private lateinit var binding: ActivityDetailLocationBinding

    private lateinit var characterIconAdapter: CharacterIconAdapter

    companion object {
        const val ID = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()

        detailLocationViewModel.getDetailLocation(idLocation = intent.getStringExtra(ID).toString())

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                detailLocationViewModel.dataDetailLocation.collectLatest {
                    val textHeader: TextView = findViewById(R.id.name_location)
                    textHeader.setText(it.detailLocation?.name)

                    val textDimension: TextView = findViewById(R.id.text_dimension)
                    if(it.detailLocation?.dimension == "unknown"){
                        textDimension.setText("Doesn't have Dimension")
                    }else {
                        textDimension.setText(it.detailLocation?.dimension)
                    }
                    val textType: TextView = findViewById(R.id.text_type)
                    textType.setText("Type ${it.detailLocation?.type}")

                    val textCreate: TextView = findViewById(R.id.text_created)
                    textCreate.setText("Created ${it.detailLocation?.created}")

                    if (it.detailLocation?.residents != null) {
                        binding.textNotFound.visibility = View.GONE
                        characterIconAdapter.submitList(it.detailLocation.residents)
                    }
                }
            }
        }

        val btnback: ImageView = findViewById(R.id.back_icon)
        btnback.setOnClickListener{
            finish()
        }
    }

    private fun setup() {
        characterIconAdapter = CharacterIconAdapter()
        binding.rvIconCharacter.apply {
            adapter = characterIconAdapter
            layoutManager = LinearLayoutManager(this@DetailLocation)
        }
    }

}