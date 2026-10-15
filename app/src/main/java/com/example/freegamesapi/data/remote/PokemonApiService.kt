package com.example.freegamesapi.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon")
    suspend fun obtenerPokemons(
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): PokemonResponseDto
}
