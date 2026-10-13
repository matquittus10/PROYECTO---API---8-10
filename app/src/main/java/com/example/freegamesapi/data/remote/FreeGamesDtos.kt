package com.example.freegamesapi.data.remote

import com.google.gson.annotations.SerializedName

/*
 * DTOs (Data Transfer Objects): clases que reflejan EXACTAMENTE la forma del JSON que
 * devuelve la API. Solo declaramos los campos que la app necesita; Gson ignora el resto.
 * Los nombres estan en ingles porque son los de la API; el modelo del dominio
 */
data class GiveawayDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("worth") val worth: String?,
    @SerializedName("thumbnail") val thumbnail: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("instructions") val instructions: String?,
    @SerializedName("open_giveaway_url") val openGiveawayUrl: String?,
    @SerializedName("published_date") val publishedDate: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("platforms") val platforms: String?,
    @SerializedName("status") val status: String?
)
