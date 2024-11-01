package com.example.pokedex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pokedex.ui.screens.PokemonDetailsScreen
import com.example.pokedex.ui.screens.PokemonsListScreen

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = "PokemonsListScreen"
    ) {
        composable("PokemonsListScreen") {
            PokemonsListScreen(
                onPokemonClick = {
                    navController.navigate("PokemonDetailsScreen/${it}")
                }
            )
        }
        composable(
            "PokemonDetailsScreen/{pokemonId}",
            arguments = listOf(navArgument("pokemonId") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            PokemonDetailsScreen(
                backStackEntry.arguments?.getString("pokemonId")
            )
        }
    }
}