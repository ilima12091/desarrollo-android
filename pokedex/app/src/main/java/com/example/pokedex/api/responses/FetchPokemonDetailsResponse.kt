package com.example.pokedex.api.responses

import com.google.gson.annotations.SerializedName

data class FetchPokemonDetailsResponse(
    val name: String,
    val sprites: Sprites,
    val height: Int,
    val weight: Int,
    val types: List<PokemonType>,
    val stats: List<PokemonStat>,
    val moves: List<PokemonMove>
)

data class Sprites(
    @SerializedName("front_default") val frontDefault: String,
    @SerializedName("back_default") val backDefault: String,
)

data class PokemonStat(
    @SerializedName("base_stat") val baseStat: Int,
    @SerializedName("effort") val effort: Int,
    val stat: Stat
)

data class Stat(
    val name: String,
    val url: String
)

data class PokemonMove(
    val move: Move,
)

data class Move(
    val name: String,
    val url: String
)