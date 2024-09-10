package com.example.vistas_estilos_navegacion_leccion_1.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.vistas_estilos_navegacion_leccion_1.ui.screens.home.components.EventsList
import com.example.vistas_estilos_navegacion_leccion_1.ui.screens.home.components.HomeCarousel
import com.example.vistas_estilos_navegacion_leccion_1.ui.screens.home.components.HomeHeader
import com.example.vistas_estilos_navegacion_leccion_1.ui.theme.ScreenBackground
import com.example.vistas_estilos_navegacion_leccion_1.ui.theme.Vistasestilosnavegacionleccion1Theme

@Composable
fun HomeScreen() {
    Column(modifier = Modifier
        .background(ScreenBackground)
        .fillMaxHeight()
        .fillMaxWidth()) {
        HomeHeader()
        HomeCarousel()
        EventsList()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Vistasestilosnavegacionleccion1Theme {
        HomeScreen()
    }
}