package com.example.rickandmortyapi.data.network

import com.apollographql.apollo3.ApolloClient
import com.example.rickandmortyapi.domain.model.Character
import com.example.rickandmortyapi.domain.model.Location.DetailLocation
import com.example.rickandmortyapi.domain.model.Location.SimpleLocation
import com.example.rickandmortyapi.domain.model.characters.SimpleCharacter
import com.example.rickandmortyapi.domain.network.RickAndMortyClient

class ApolloRickAndMortyClient(
    private val apolloClient: ApolloClient
): RickAndMortyClient {
    override suspend fun getCharacters(): List<SimpleCharacter> {
        TODO("Not yet implemented")
    }

    override suspend fun getDetailCharacter(): Character {
        TODO("Not yet implemented")
    }

    override suspend fun getLocations(): List<SimpleLocation> {
        TODO("Not yet implemented")
    }

    override suspend fun getDetailLocation(): DetailLocation{
        TODO("Not yet implemented")
    }


}