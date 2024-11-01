package com.example.pokedex.api.responses

data class FetchPokemonResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonItem>
)

data class PokemonItem(
    val name: String,
    val url: String,
    val details: PokemonDetails? = null,
)

data class PokemonDetails(
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<PokemonType>,
    val sprites: Sprites,
)

data class PokemonType(
    val slot: Int,
    val type: Type,
)

data class Type(
    val name: String,
    val url: String,
)

data class PokemonsResponse(
    val count: Int,
    val nextOffset: String?,
    val previous: String?,
    val results: List<PokemonItem>
)