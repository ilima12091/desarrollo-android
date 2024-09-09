package com.example.vistas_estilos_navegacion_leccion_1.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vistas_estilos_navegacion_leccion_1.ui.theme.Orange100

@Composable
fun EventContent() {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .size(200.dp)
            .background(Orange100)
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.height(200.dp)
        ) {
            Column {
                Text(text = "08", color = Color.White)
                Text(text = "June", color = Color.White)
            }
            Column {
                Text(text = "Surakarta", color = Color.White)
                Text(text = "Clean City", color = Color.White)
                Text(text = "Together", color = Color.White)
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    Icons.Rounded.LocationOn,
                    contentDescription = "Location icon",
                    modifier = Modifier.size(12.dp),
                    tint = Color.White
                )
                Text(text = "Surakarta, INA", fontSize = 10.sp, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventContentPreview() {
    EventContent()
}