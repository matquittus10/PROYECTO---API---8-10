package com.example.freegamesapi.Model

class Usuario(
    var id: Int,
    var nombre: String,
    var email: String,
) {
    private val favoritos: MutableList<Juego> = mutableListOf()

    fun agregarFavorito(juego: Juego) {
        favoritos.add(juego)
    }

    fun quitarFavorito(juego: Juego) {
        favoritos.remove(juego)
    }

    fun verFavoritos(): List<Juego> {
        return favoritos
    }
}
