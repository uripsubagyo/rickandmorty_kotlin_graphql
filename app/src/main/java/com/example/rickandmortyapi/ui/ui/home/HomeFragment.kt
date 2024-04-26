package com.example.rickandmortyapi.ui.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.rickandmortyapi.databinding.FragmentHomeBinding
import com.example.rickandmortyapi.domain.use_case.character.GetCharactersUseCase
import com.example.rickandmortyapi.ui.MainHomeActivity
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.lang.Exception

//@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        homeViewModel = (activity as MainHomeActivity).viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.shortCharacter.collectLatest { value ->
                    Log.d("HomeFragment", "datA: ${value.characters}")
                }
            }
        }

        Log.d("CHECK_33", homeViewModel.shortCharacter.value.locations.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}