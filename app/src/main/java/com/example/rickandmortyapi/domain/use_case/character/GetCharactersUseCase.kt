package com.example.rickandmortyapi.domain.use_case.character

import android.util.Log
import com.example.rickandmortyapi.domain.model.characters.SimpleCharacter
import com.example.rickandmortyapi.domain.network.RickAndMortyClient
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val client : RickAndMortyClient
) {
    suspend fun execute() : List<SimpleCharacter> {
        Log.d("UC", "called")
        return client.getCharacters()
    }
}