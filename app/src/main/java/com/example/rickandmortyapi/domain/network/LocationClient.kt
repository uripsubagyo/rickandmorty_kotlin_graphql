package com.example.rickandmortyapi.domain.network

import com.example.rickandmortyapi.domain.model.Location.DetailLocation
import com.example.rickandmortyapi.domain.model.Location.SimpleLocation

interface LocationClient {
    suspend fun getLocations(page: Int): List<SimpleLocation>

    suspend fun getDetailLocation(id: String): DetailLocation?
}