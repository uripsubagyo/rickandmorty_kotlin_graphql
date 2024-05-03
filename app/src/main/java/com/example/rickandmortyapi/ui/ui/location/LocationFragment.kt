package com.example.rickandmortyapi.ui.ui.location

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentCharacterBinding
import com.example.rickandmortyapi.databinding.FragmentHomeBinding
import com.example.rickandmortyapi.ui.MainHomeActivity
import com.example.rickandmortyapi.ui.ui.home.Adapter.LocationsListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import okhttp3.internal.notifyAll

@AndroidEntryPoint
class LocationFragment : Fragment() {

    private var _binding : FragmentCharacterBinding? = null
    private val binding get() = _binding!!

    private val locationViewModel: LocationViewModel by viewModels()
    private lateinit var locationsListAdapter: LocationsListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterBinding.inflate(inflater,container, false)

        setupRecycleView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                locationViewModel.locations.collectLatest { value ->
                    if(value.locations.isNotEmpty()){
                        locationsListAdapter.submitList(value.locations)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecycleView(){
        locationsListAdapter = LocationsListAdapter()
        binding.rvCharacterCharFrag.apply {
            adapter = locationsListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        binding.rvCharacterCharFrag.addOnScrollListener(object  : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy>locationViewModel.locations.value.locations.count() -3){
                    locationViewModel.callMoreData()
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }
}