package com.example.vistas_estilos_navegacion_leccion_1.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.vistas_estilos_navegacion_leccion_1.ui.screens.home.components.HomeCarousel
import com.example.vistas_estilos_navegacion_leccion_1.ui.screens.home.components.HomeHeader
import com.example.vistas_estilos_navegacion_leccion_1.ui.theme.Vistasestilosnavegacionleccion1Theme

@Composable
fun HomeScreen() {
    HomeHeader()
    HomeCarousel()
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Vistasestilosnavegacionleccion1Theme {
        HomeScreen()
    }
}