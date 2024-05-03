package com.example.rickandmortyapi.ui.ui.character

import com.example.rickandmortyapi.domain.model.characters.SimpleCharacter

data class CharacterState (
    val characters: List<SimpleCharacter> = emptyList(),
    val isLoading: Boolean = false,
)