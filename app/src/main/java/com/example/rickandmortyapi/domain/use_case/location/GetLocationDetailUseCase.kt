package com.example.rickandmortyapi.domain.use_case.location

import com.example.rickandmortyapi.domain.model.Location.DetailLocation
import com.example.rickandmortyapi.domain.network.LocationClient
import javax.inject.Inject

class GetLocationDetailUseCase @Inject constructor(
    private val client: LocationClient
){
    suspend fun execute(id:String) : DetailLocation? {
        return client.getDetailLocation(id)
    }
}