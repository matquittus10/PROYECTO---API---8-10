package com.example.freegamesapi.data

import com.example.freegamesapi.data.remote.GameDto
import com.example.freegamesapi.data.remote.PokemonDto
import com.example.freegamesapi.model.Juego
import com.example.freegamesapi.model.Pokemon


object MapeadorPokemon {

    /**
     * Convierte un GameDto (respuesta de la API) a la clase de dominio Juego.
     */
    fun pokemonDtoToPokemon(dto: PokemonDto): Pokemon {
        return Pokemon(
            name = dto.name,
            url = dto.url,
        )
    }

    /**
     * Convierte una lista de GameDto a una lista de objetos Juego.
     */
    fun listPokemonDtoToListPokemon(dtos: List<PokemonDto>): List<Pokemon> {
        return dtos.map { pokemonDtoToPokemon(it) }
    }
}
