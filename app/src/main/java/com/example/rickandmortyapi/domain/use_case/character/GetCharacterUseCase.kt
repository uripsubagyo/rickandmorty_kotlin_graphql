package com.example.rickandmortyapi.domain.use_case.character

import com.example.rickandmortyapi.domain.model.Character
import com.example.rickandmortyapi.domain.network.RickAndMortyClient
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val client: RickAndMortyClient
) {
    suspend fun execute(id: String) : Character? {
        return client.getDetailCharacterById(id)
    }
}