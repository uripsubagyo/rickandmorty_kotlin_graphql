package com.example.rickandmortyapi.domain.use_case.location

import android.util.Log
import com.example.rickandmortyapi.domain.model.Location.SimpleLocation
import com.example.rickandmortyapi.domain.network.LocationClient
import javax.inject.Inject

class GetLocationsUseCase @Inject constructor(
    private val client: LocationClient
) {
    suspend fun execute(page:Int): List<SimpleLocation>{
        return client.getLocations(page)
    }
}