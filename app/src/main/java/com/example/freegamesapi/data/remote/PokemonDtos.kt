package com.example.freegamesapi.data.remote

import com.google.gson.annotations.SerializedName

/**
 * DTO envoltorio para la respuesta de la PokéAPI.
 */
data class PokemonResponseDto(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<PokemonDto>,
)

data class PokemonDto(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
)
