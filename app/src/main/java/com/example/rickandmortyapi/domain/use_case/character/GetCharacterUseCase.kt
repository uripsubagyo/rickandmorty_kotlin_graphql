package com.example.rickandmortyapi.domain.use_case.character

import com.example.rickandmortyapi.domain.model.characters.Character
import com.example.rickandmortyapi.domain.network.CharacterClient
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val client: CharacterClient
) {
    suspend fun execute(id: String) : Character? {
        return client.getDetailCharacterById(id)
    }
}