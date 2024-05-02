package com.example.rickandmortyapi.ui.ui.detailCharacter

import com.example.rickandmortyapi.domain.model.Character

data class DetailCharacterState(
    val isLoading: Boolean = false,
    val detailCharacter: Character? = null
)