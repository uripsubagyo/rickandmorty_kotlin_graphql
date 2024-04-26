package com.example.rickandmortyapi.ui.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.domain.use_case.character.GetCharactersUseCase
import com.example.rickandmortyapi.domain.use_case.location.GetLocationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val getLocationsUseCase: GetLocationsUseCase
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    val text: LiveData<String> = _text

    private val _shortCharacter = MutableStateFlow(HomeState())

    val shortCharacter = _shortCharacter.asStateFlow()

    init {
        viewModelScope.launch {
            getCharactersUseCase.execute()
        }
//        viewModelScope.launch {
//            _shortCharacter.update {
//                it.copy(
//                    isLoading = true
//                )
//            }
//            _shortCharacter.update {
//                it.copy(
//                    characters = getCharactersUseCase.execute(),
//                    locations = getLocationsUseCase.execute(),
//                    isLoading = false
//                )
//            }
//
//        }
    }

}