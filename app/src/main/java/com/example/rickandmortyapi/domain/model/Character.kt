package com.example.rickandmortyapi.domain.model

data class Character(
    val id: String,
    val name: String,
    val species: String,
    val status: String,
    val gender: String,
    val origin: OriginCharacter,
    val image: String,
    val created: String
)

data class OriginCharacter(
    val name: String
)
