package com.example.rickandmortyapi.present.ui.detailCharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.domain.use_case.character.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailCharacterViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase
): ViewModel() {
    private val _dataDetailCharacter = MutableStateFlow(DetailCharacterState())
    val dataDetailCharacter = _dataDetailCharacter.asStateFlow()

    fun getDetailCharacter(idCharacter: String) = viewModelScope.launch {

        _dataDetailCharacter.update {
            it.copy(
                isLoading = true
            )
        }

        _dataDetailCharacter.update {
            it.copy(
                detailCharacter = getCharacterUseCase.execute(idCharacter),
                isLoading = false
            )
        }
    }
}