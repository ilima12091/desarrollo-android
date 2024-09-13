package com.example.vistas_estilos_navegacion_leccion_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.vistas_estilos_navegacion_leccion_1.ui.navigation.MainNavHost
import com.example.vistas_estilos_navegacion_leccion_1.ui.theme.Vistasestilosnavegacionleccion1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Vistasestilosnavegacionleccion1Theme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainNavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = "LoginScreen"
                    )
                }
            }
        }
    }
}
