package com.example.freegamesapi.data

import com.example.freegamesapi.data.remote.GameDto
import com.example.freegamesapi.data.remote.RetrofitClient
import com.example.freegamesapi.model.Juego
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FreeGamesRepository {

    private val api = RetrofitClient.api
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    suspend fun obtenerJuegos(
        plataforma: String? = null,
        categoria: String? = null,
        ordenarPor: String? = null,
    ): List<Juego> {
        return try {
            val dtos = api.obtenerJuegos(plataforma, categoria, ordenarPor)
            dtos.map { dtoToJuego(it) }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun obtenerJuegoPorId(id: Int): Juego? {
        return try {
            val dto = api.obtenerJuegoPorId(id)
            dtoToJuego(dto)
        } catch (e: Exception) {
            null
        }
    }

    private fun dtoToJuego(dto: GameDto): Juego {
        val fecha = try {
            dto.releaseDate?.let { dateFormat.parse(it) } ?: Date()
        } catch (e: Exception) {
            Date()
        }

        return Juego(
            id = dto.id,
            nombre = dto.title,
            descripcion = dto.shortDescription ?: dto.description ?: "Sin descripción",
            urlDescarga = dto.gameUrl ?: "",
            fechaLanzamiento = fecha,
            desarrollador = dto.developer ?: dto.publisher ?: "Desconocido",
        )
    }
}
