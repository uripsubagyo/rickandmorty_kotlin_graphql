package com.example.rickandmortyapi.present.ui.detailLocation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.domain.use_case.location.GetLocationDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailLocationViewModel @Inject constructor(
    private val getLocationDetailUseCase: GetLocationDetailUseCase
): ViewModel() {

    private val _dataDetailLocation = MutableStateFlow(DetailLocationState())
    val dataDetailLocation = _dataDetailLocation.asStateFlow()

    fun getDetailLocation(idLocation: String) = viewModelScope.launch {
        _dataDetailLocation.update {
            it.copy(
                isLoading = true
            )
        }

        _dataDetailLocation.update {
            it.copy(
                detailLocation = getLocationDetailUseCase.execute(idLocation),
                isLoading = false
            )
        }
    }

}