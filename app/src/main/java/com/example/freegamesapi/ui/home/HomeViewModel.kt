package com.example.freegamesapi.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freegamesapi.data.FreeGamesRepository
import com.example.freegamesapi.data.PokemonRepository
import com.example.freegamesapi.model.Juego
import com.example.freegamesapi.model.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Success(val juegos: List<Juego>) : HomeUiState
    data class Success2(val pokemon: List<Pokemon>) : HomeUiState

    data class Error(val mensaje: String) : HomeUiState
}

class HomeViewModel(
    private val repository: FreeGamesRepository = FreeGamesRepository(),
    private val repository2: PokemonRepository = PokemonRepository()

) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        cargarPokemons()
    }

    fun cargarJuegos(
        plataforma: String? = null,
        categoria: String? = null,
        ordenarPor: String? = null
    ) {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            try {
                val juegos = repository.obtenerJuegos(plataforma, categoria, ordenarPor)
                _uiState.value = HomeUiState.Success(juegos)
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error("Error al cargar juegos: ${e.message}")
            }
        }
    }

    fun cargarPokemons(
        limit: Int? = null,
        offset: Int? = null
    ) {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            try {
                val pokemones = repository2.obtenerPokemon(limit, offset)
                _uiState.value = HomeUiState.Success2(pokemones)
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error("Error al cargar pokemones: ${e.message}")
            }
        }
    }
}
