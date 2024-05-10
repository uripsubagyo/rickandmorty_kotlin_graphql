package com.example.rickandmortyapi.present.ui.location

import com.example.rickandmortyapi.domain.model.Location.SimpleLocation

data class LocationState (
    val locations: List<SimpleLocation> = emptyList(),
    val isLoading: Boolean = false,
    val page: Int = 1
)