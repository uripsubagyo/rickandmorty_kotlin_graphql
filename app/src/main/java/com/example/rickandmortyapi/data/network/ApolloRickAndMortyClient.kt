package com.example.rickandmortyapi.data.network

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException
import com.example.rickandmortyapi.CharacterQuery
import com.example.rickandmortyapi.CharactersQuery
import com.example.rickandmortyapi.LocationQuery
import com.example.rickandmortyapi.LocationsQuery
import com.example.rickandmortyapi.data.mapper.toCharacter
import com.example.rickandmortyapi.data.mapper.toCharacterList
import com.example.rickandmortyapi.domain.model.Character
import com.example.rickandmortyapi.domain.model.Location.DetailLocation
import com.example.rickandmortyapi.domain.model.Location.SimpleLocation
import com.example.rickandmortyapi.domain.model.characters.SimpleCharacter
import com.example.rickandmortyapi.domain.network.RickAndMortyClient
import toDetailLocation
import toLocationList
import javax.inject.Inject

class ApolloRickAndMortyClient @Inject constructor(
    private val apolloClient: ApolloClient
) : RickAndMortyClient {

    override suspend fun getCharacters(): List<SimpleCharacter> {
        Log.d("ApolloClient", "called")
        Log.d("ApolloClient", "${apolloClient
            .query(CharactersQuery(0))
            .execute()}")

        return try {
            apolloClient.query(CharactersQuery(0))
                .execute()
                .data
                ?.characters
                ?.toCharacterList() ?: emptyList()
        } catch (err: ApolloException) {
            Log.e("ERROR_APOLLO", err.toString())
            emptyList<SimpleCharacter>()
        }
    }


    override suspend fun getDetailCharacterById(id: String): Character? =
        apolloClient.query(CharacterQuery(id))
            .execute()
            .data
            ?.character
            ?.toCharacter()

    override suspend fun getLocations(): List<SimpleLocation> =
        apolloClient.query(LocationsQuery(1))
            .execute()
            .data
            ?.locations
            ?.toLocationList()
            .orEmpty()

    override suspend fun getDetailLocation(id: String): DetailLocation? =
        apolloClient.query(LocationQuery(id))
            .execute()
            .data
            ?.location
            ?.toDetailLocation()


}