package com.example.freegamesapi.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Define los endpoints de la API. Retrofit genera la implementacion en tiempo de ejecucion.
 * Al ser funciones `suspend`, se ejecutan fuera del hilo principal dentro de una corrutina.
 *
 * Documentacion de la API:
 * https://www.gamerpower.com/api-read
 */
interface FreeGamesApiService {

    /** Obtiene la lista de juegos gratuitos (giveaways). */
    @GET("giveaways")
    suspend fun obtenerGiveaways(
        @Query("platform") plataforma: String? = null,
        @Query("type") tipo: String? = null,
        @Query("sort-by") ordenarPor: String? = null
    ): List<GiveawayDto>

    /** Obtiene el detalle de un juego gratuito por su id. */
    @GET("giveaway")
    suspend fun obtenerGiveawayPorId(
        @Query("id") id: Int
    ): GiveawayDto
}
