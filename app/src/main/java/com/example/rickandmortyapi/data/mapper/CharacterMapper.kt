package com.example.rickandmortyapi.data.mapper

import com.example.rickandmortyapi.CharacterQuery
import com.example.rickandmortyapi.CharactersQuery
import com.example.rickandmortyapi.domain.model.characters.Character
import com.example.rickandmortyapi.domain.model.characters.OriginCharacter
import com.example.rickandmortyapi.domain.model.characters.SimpleCharacter

fun CharactersQuery.Characters.toCharacterList(): List<SimpleCharacter> {
    return this.results?.mapNotNull { result ->
        SimpleCharacter(
            id = result?.id.orEmpty(),
            name = result?.name.orEmpty(),
            image = result?.image.orEmpty(),
            species = result?.species.orEmpty()
        )
    }.orEmpty()
}


fun CharacterQuery.Character.toCharacter(): Character =
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


