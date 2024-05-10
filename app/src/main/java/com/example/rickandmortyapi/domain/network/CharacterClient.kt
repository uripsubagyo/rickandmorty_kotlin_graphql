package com.example.rickandmortyapi.domain.network

import com.example.rickandmortyapi.domain.model.characters.Character
import com.example.rickandmortyapi.domain.model.characters.SimpleCharacter

interface CharacterClient {
    suspend fun getCharacters(page: Int): List<SimpleCharacter>

    suspend fun getDetailCharacterById(id:String): Character?
}