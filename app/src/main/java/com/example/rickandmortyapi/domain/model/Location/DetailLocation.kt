package com.example.rickandmortyapi.domain.model.Location

import androidx.lifecycle.viewmodel.CreationExtras
import com.example.rickandmortyapi.ui.ui.detailLocation.DetailLocation

data class DetailLocation (
    val id: String,
    val  name: String,
    val   type: String,
    val  dimension: String,
    val   created: String,
    val  residents:List<ResidenceCharacter>
){
}
data class ResidenceCharacter(
    val name: String,
    val status: String,
    val gender: String,
    val image: String,
    val type: String
)
