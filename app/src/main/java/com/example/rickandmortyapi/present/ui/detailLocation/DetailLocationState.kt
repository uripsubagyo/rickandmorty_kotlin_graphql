package com.example.rickandmortyapi.present.ui.detailLocation

import com.example.rickandmortyapi.domain.model.Location.DetailLocation

data class DetailLocationState(
    val isLoading: Boolean = false,
    val detailLocation: DetailLocation? = null
)