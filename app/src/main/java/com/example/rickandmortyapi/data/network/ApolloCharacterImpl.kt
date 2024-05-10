package com.example.rickandmortyapi.data.network

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException
import com.example.rickandmortyapi.CharacterQuery
import com.example.rickandmortyapi.CharactersQuery
import com.example.rickandmortyapi.data.mapper.toCharacter
import com.example.rickandmortyapi.data.mapper.toCharacterList
import com.example.rickandmortyapi.domain.model.characters.Character
import com.example.rickandmortyapi.domain.model.characters.SimpleCharacter
import com.example.rickandmortyapi.domain.network.CharacterClient
import javax.inject.Inject

class ApolloCharacterImpl @Inject constructor(
    private val apolloClient: ApolloClient
) : CharacterClient {

    override suspend fun getCharacters(page: Int): List<SimpleCharacter> {
        return try {
            apolloClient.query(CharactersQuery(page))
                .execute()
                .data
                ?.characters
                ?.toCharacterList() ?: emptyList()
        } catch (err: ApolloException) {
            Log.e("ERROR_APOLLO", err.toString())
            emptyList<SimpleCharacter>()
        }
    }


    override suspend fun getDetailCharacterById(id: String): Character? {
        return try {
            apolloClient.query(CharacterQuery(id))
                .execute()
                .data
                ?.character
                ?.toCharacter()
        } catch (err: ApolloException){
            Log.e("ERROR_APOLLO", err.toString())
            null
        }
    }

}