package com.example.vistas_estilos_navegacion_leccion_1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.vistas_estilos_navegacion_leccion_1.ui.screens.LoginScreen
import com.example.vistas_estilos_navegacion_leccion_1.ui.screens.home.HomeScreen

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String
) {
    NavHost(navController, startDestination, modifier = modifier) {
        composable("LoginScreen") {
            LoginScreen()
        }
        composable("HomeScreen") {
            HomeScreen()
        }
    }
}