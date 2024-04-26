package com.example.rickandmortyapi.data.mapper

import android.util.Log
import com.example.rickandmortyapi.CharacterQuery
import com.example.rickandmortyapi.CharactersQuery
import com.example.rickandmortyapi.domain.model.Character
import com.example.rickandmortyapi.domain.model.OriginCharacter
import com.example.rickandmortyapi.domain.model.characters.SimpleCharacter

fun CharactersQuery.Characters.toCharacterList(): List<SimpleCharacter> {
    Log.d("Mapper", "data: ${results?.getOrNull(0) ?: "empty"}")
    Log.d("CHECK_MAP", "PASSSS")
    return this.results?.mapNotNull { result ->
        SimpleCharacter(
            id = result?.id.orEmpty(),
            name = result?.id.orEmpty(),
            image = result?.id.orEmpty(),
            species = result?.id.orEmpty()
        )
    }.orEmpty()
}


fun CharacterQuery.Character.toCharacter():Character  =
    Character(
        id = this.id.orEmpty(),
        name = this.name.orEmpty(),
        species = this.species.orEmpty(),
        status = this.species.orEmpty(),
        gender = this.gender.orEmpty(),
        origin = OriginCharacter(this.origin?.name.orEmpty()),
        image = this.image.orEmpty(),
        created = this.created.orEmpty()
    )


