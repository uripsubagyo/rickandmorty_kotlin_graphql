package com.example.rickandmortyapi.present.ui.home

import com.example.rickandmortyapi.domain.model.Location.SimpleLocation
import com.example.rickandmortyapi.domain.model.characters.SimpleCharacter


data class HomeState(
    val characters: List<SimpleCharacter> = emptyList(),
    val locations: List<SimpleLocation> = emptyList(),
    val isLoading: Boolean = false
)
