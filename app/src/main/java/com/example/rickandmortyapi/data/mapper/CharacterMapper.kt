package com.example.rickandmortyapi.data.mapper

import com.example.CharactersQuery
import com.example.rickandmortyapi.domain.model.Character
import com.example.rickandmortyapi.domain.model.characters.SimpleCharacter

fun CharactersQuery.Characters.toCharacterList(): List<SimpleCharacter> =
    this.results?.mapNotNull {
        result ->
            SimpleCharacter(
                id = result?.id.orEmpty(),
                name = result?.id.orEmpty(),
                image = result?.id.orEmpty(),
                species = result?.id.orEmpty()
            )
    }.orEmpty()


//fun CharactersQuery.Characters.toCharacterDetail(): Character



