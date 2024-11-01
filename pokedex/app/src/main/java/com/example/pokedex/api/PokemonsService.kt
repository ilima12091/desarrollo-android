package com.example.pokedex.api

import com.example.pokedex.api.responses.FetchPokemonDetailsResponse
import com.example.pokedex.api.responses.FetchPokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonsService {
    @GET("pokemon")
    suspend fun fetchPokemons(@Query("limit") limit: String, @Query("offset") offset: String): FetchPokemonResponse

    @GET("pokemon/{pokemonName}")
    suspend fun fetchPokemonDetails(@Path("pokemonName") pokemonName: String): FetchPokemonDetailsResponse

}