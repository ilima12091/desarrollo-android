package com.example.pokedex.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.api.responses.FetchPokemonDetailsResponse
import com.example.pokedex.api.responses.PokemonDetails
import com.example.pokedex.api.responses.PokemonItem
import com.example.pokedex.data.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class PokemonsListScreenUiState(
    val pokemonList: List<PokemonItem> = emptyList(),
    val pokemonDetails: FetchPokemonDetailsResponse? = null,
    val isLoading: Boolean = false,
    val nextOffset: String? = null
)

class PokemonsListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PokemonsListScreenUiState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchPokemons()
    }

    private fun fetchPokemons() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }
            val pokemons = PokemonRepository.fetchPokemons()
            val result = mutableListOf<PokemonItem>()
            pokemons.results.forEach {
                val details = PokemonRepository.fetchPokemonDetails(it.name)
                val newPokemon = it.copy(details = PokemonDetails(
                    name = details.name,
                    height = details.height,
                    weight = details.weight,
                    types = details.types,
                    sprites = details.sprites
                ))
                result.add(newPokemon)
            }
            _uiState.update {
                it.copy(
                    pokemonList = result,
                    isLoading = false,
                    nextOffset = pokemons.nextOffset
                )
            }
        }
    }

    fun fetchMorePokemons () {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }
            val pokemons = PokemonRepository.fetchPokemons(
                offset = _uiState.value.nextOffset ?: "0"
            )
            val result = mutableListOf<PokemonItem>()
            result.addAll(_uiState.value.pokemonList)
            pokemons.results.forEach {
                val details = PokemonRepository.fetchPokemonDetails(it.name)
                val newPokemon = it.copy(details = PokemonDetails(
                    name = details.name,
                    height = details.height,
                    weight = details.weight,
                    types = details.types,
                    sprites = details.sprites
                ))
                result.add(newPokemon)
            }
            _uiState.update {
                it.copy(
                    pokemonList = result,
                    isLoading = false,
                    nextOffset = pokemons.nextOffset
                )
            }
        }
    }
}