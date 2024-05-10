package com.example.rickandmortyapi.present.ui.character

import com.example.rickandmortyapi.domain.model.characters.SimpleCharacter

data class CharacterState (
    val characters: List<SimpleCharacter> = emptyList(),
    val isLoading: Boolean = false,
    val page: Int = 1
)