package com.example.freegamesapi.data

import com.example.freegamesapi.data.remote.RetrofitClient
import com.example.freegamesapi.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepository {
    private val api2 = RetrofitClient.api2

    suspend fun obtenerPokemon(
        limit: Int? = null,
        offset: Int? = null,
    ): List<Pokemon> = withContext(Dispatchers.IO) {
        try {
            val response = api2.obtenerPokemons(limit, offset)
            MapeadorPokemon.listPokemonDtoToListPokemon(response.results)
        } catch (e: Exception) {
            emptyList()
        }
    }
}
