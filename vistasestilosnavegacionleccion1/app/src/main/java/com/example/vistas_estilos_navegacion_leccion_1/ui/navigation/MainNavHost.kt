package com.example.vistas_estilos_navegacion_leccion_1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.vistas_estilos_navegacion_leccion_1.ui.screens.LoginScreen
import com.example.vistas_estilos_navegacion_leccion_1.ui.screens.UserDetailsScreen
import com.example.vistas_estilos_navegacion_leccion_1.ui.screens.home.HomeScreen

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String
) {
    NavHost(navController, startDestination, modifier = modifier) {
        composable("LoginScreen") {
            LoginScreen(
                navigateToHome = { userEmail: String ->
                    navController.navigate("HomeScreen/$userEmail")
                }
            )
        }
        composable(
            "HomeScreen/{userEmail}",
            arguments = listOf(navArgument("userEmail") { type = NavType.StringType }),
        ) {
            HomeScreen(
                userEmail = it.arguments?.getString("userEmail") ?: "",
                navigateToLogin = {
                    navController.navigate("LoginScreen")
                },
                navigateToUserDetails = {
                    navController.navigate("UserDetailsScreen")
                }

            )
        }
        composable("UserDetailsScreen") {
            UserDetailsScreen()
        }
    }
}