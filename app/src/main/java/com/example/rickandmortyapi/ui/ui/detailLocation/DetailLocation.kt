package com.example.rickandmortyapi.ui.ui.detailLocation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.lifecycle.*
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.ActivityDetailLocationBinding
import com.example.rickandmortyapi.ui.ui.detailLocation.Adapter.CharacterIconAdapter
import com.example.rickandmortyapi.ui.ui.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.lang.Exception


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
        binding.backIcon.setOnClickListener{
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