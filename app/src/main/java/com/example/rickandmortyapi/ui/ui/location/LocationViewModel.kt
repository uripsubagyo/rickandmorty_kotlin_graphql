package com.example.rickandmortyapi.ui.ui.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.domain.use_case.location.GetLocationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val getLocationsUseCase: GetLocationsUseCase
)
    : ViewModel() {

    private val _locations = MutableStateFlow((LocationState()))
    val locations = _locations.asStateFlow()

    init {
        viewModelScope.launch {
            _locations.update {
                it.copy(
                    isLoading = true
                )
            }
            _locations.update {
                it.copy(
                    locations =  getLocationsUseCase.execute(locations.value.page),
                    isLoading = false
                )
            }
        }
    }


    fun callMoreData(){
        viewModelScope.launch{
            _locations.update {
                it.copy(
                    locations = it.locations + getLocationsUseCase.execute(locations.value.page + 1)
                )
            }
        }
    }
}