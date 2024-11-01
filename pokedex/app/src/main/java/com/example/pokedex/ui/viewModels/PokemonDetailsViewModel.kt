package com.example.pokedex.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.api.responses.FetchPokemonDetailsResponse
import com.example.pokedex.data.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class PokemonDetailsScreenUiState(
    val pokemonDetails: FetchPokemonDetailsResponse? = null,
    val showFrontSprite: Boolean = true,
    val isLoading: Boolean = false
)

class PokemonDetailsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PokemonDetailsScreenUiState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchPokemonDetails("bulbasaur")
    }

    fun fetchPokemonDetails(name: String) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            val pokemonDetails = PokemonRepository.fetchPokemonDetails(name)
            _uiState.update {
                it.copy(
                    pokemonDetails = pokemonDetails,
                    isLoading = false
                )
            }
        }
    }

    fun toggleSprite() {
        _uiState.update {
            it.copy(showFrontSprite = !it.showFrontSprite)
        }
    }
}