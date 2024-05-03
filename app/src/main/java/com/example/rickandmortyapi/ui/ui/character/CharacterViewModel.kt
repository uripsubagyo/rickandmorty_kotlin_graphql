package com.example.rickandmortyapi.ui.ui.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.domain.use_case.character.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Character Fragment"
    }
    val text: LiveData<String> = _text

    private val _characters = MutableStateFlow(CharacterState())

    val characters = _characters.asStateFlow()

    init {
        viewModelScope.launch {
            _characters.update {
                it.copy(
                    isLoading = true
                )
            }
            _characters.update { it.copy(
                characters = getCharactersUseCase.execute(),
                isLoading = false
            ) }
        }
    }
}