package com.example.rickandmortyapi.present.ui.detailCharacter

import com.example.rickandmortyapi.domain.model.characters.Character

data class DetailCharacterState(
    val isLoading: Boolean = false,
    val detailCharacter: Character? = null
)