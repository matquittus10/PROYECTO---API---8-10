package com.example.freegamesapi.data

import com.example.freegamesapi.data.remote.GiveawayDto
import com.example.freegamesapi.data.remote.RetrofitClient
import com.example.freegamesapi.model.Juego
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FreeGamesRepository {

    private val api = RetrofitClient.api
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

    suspend fun obtenerJuegos(
        plataforma: String? = null,
        tipo: String? = null,
        ordenarPor: String? = null
    ): List<Juego> {
        return try {
            val dtos = api.obtenerGiveaways(plataforma, tipo, ordenarPor)
            dtos.map { dtoToJuego(it) }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun obtenerJuegoPorId(id: Int): Juego? {
        return try {
            val dto = api.obtenerGiveawayPorId(id)
            dtoToJuego(dto)
        } catch (e: Exception) {
            null
        }
    }

    private fun dtoToJuego(dto: GiveawayDto): Juego {
        val fecha = try {
            dto.publishedDate?.let { dateFormat.parse(it) } ?: Date()
        } catch (e: Exception) {
            Date()
        }

        return Juego(
            id = dto.id,
            nombre = dto.title,
            descripcion = dto.description ?: "Sin descripción",
            urlDescarga = dto.openGiveawayUrl ?: "",
            fechaLanzamiento = fecha,
            desarrollador = "GamerPower"
        )
    }
}
