package com.example.pokedex.data

import com.example.pokedex.api.PokemonClient
import com.example.pokedex.api.responses.FetchPokemonDetailsResponse
import com.example.pokedex.api.responses.PokemonItem
import com.example.pokedex.api.responses.PokemonsResponse
import com.example.pokedex.api.utils.getOffsetValue

object PokemonRepository {

    suspend fun fetchPokemons(
        limit: String = "20",
        offset: String = "0"
    ): PokemonsResponse {
        val response = PokemonClient.service.fetchPokemons(
            limit = limit,
            offset = offset
        )
        return PokemonsResponse(
            count = response.count,
            nextOffset = getOffsetValue(response.next ?: ""),
            previous = response.previous,
            results = response.results
        )
    }

    suspend fun fetchPokemonDetails(name: String): FetchPokemonDetailsResponse {
        return PokemonClient.service.fetchPokemonDetails(name)
    }
}