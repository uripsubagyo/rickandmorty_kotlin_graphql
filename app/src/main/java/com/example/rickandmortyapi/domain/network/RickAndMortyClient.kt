package com.example.rickandmortyapi.domain.network

import com.example.rickandmortyapi.domain.model.Character
import com.example.rickandmortyapi.domain.model.Location.DetailLocation
import com.example.rickandmortyapi.domain.model.Location.SimpleLocation
import com.example.rickandmortyapi.domain.model.characters.SimpleCharacter

interface RickAndMortyClient {

    suspend fun getCharacters(): List<SimpleCharacter>

    suspend fun getDetailCharacter(): Character

    suspend fun getLocations(): List<SimpleLocation>

    suspend fun getDetailLocation(): DetailLocation
}