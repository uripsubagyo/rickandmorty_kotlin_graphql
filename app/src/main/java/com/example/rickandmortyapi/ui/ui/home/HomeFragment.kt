package com.example.rickandmortyapi.ui.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentHomeBinding
import com.example.rickandmortyapi.ui.MainHomeActivity
import com.example.rickandmortyapi.ui.ui.character.CharacterFragment
import com.example.rickandmortyapi.ui.ui.home.Adapter.CharacterListAdapter
import com.example.rickandmortyapi.ui.ui.home.Adapter.LocationsListAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var characterListAdapter: CharacterListAdapter
    private lateinit var locationListAdapter: LocationsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        homeViewModel = (activity as MainHomeActivity).viewModel

        setupRecyclerView()

        binding.seeMoreCharacter.setOnClickListener {
            findNavController().navigate(R.id.navigation_character)
        }

        binding.seeMoreLocation.setOnClickListener{
            findNavController().navigate(R.id.navigation_character)
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.shortCharacter.collectLatest { value ->
                    if (value.characters.isNotEmpty()) {
                        characterListAdapter.submitList(value.characters.subList(0, value.characters.size / 4))
                    }
                    if (value.locations.isNotEmpty()) {
                        locationListAdapter.submitList(value.locations.subList(0, value.locations.size / 4))
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        characterListAdapter = CharacterListAdapter()
        binding.rvCharacter.apply {
            adapter = characterListAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        locationListAdapter = LocationsListAdapter()
        binding.rvLocation.apply {
            adapter = locationListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}