package com.example.freegamesapi.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/** Unica instancia de Retrofit de la app (patron singleton con `object`). */
object RetrofitClient {

    private const val BASE_URL = "https://www.freetogame.com/api/"
    private const val BASE_URL2 = "https://pokeapi.co/api/v2/"

    private val clienteHttp: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC })
        .build()

    val api: FreeGamesApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(clienteHttp)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FreeGamesApiService::class.java)
    }

    val api2: PokemonApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .client(clienteHttp)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApiService::class.java)
    }
}
