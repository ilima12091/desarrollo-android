package com.example.vistas_estilos_navegacion_leccion_1.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vistas_estilos_navegacion_leccion_1.R

@Composable
fun EventRow() {
    Row(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.White)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Event image",
                Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Jun", color = Color.White, fontSize = 12.sp)
                Text(text = "12", color = Color.White, fontSize = 20.sp)
            }
        }
        Column {
            Text(text = "Volunteer Solosup", fontWeight = FontWeight.SemiBold)
            Text(text = "09:00 AM to 03:00 PM", color = Color.Gray)
            Text(text = "Surakarta, INA", color = Color.Gray)
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF5F6FA)
            ),
            shape = RoundedCornerShape(12.dp),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Text(text = "Join", color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventRowPreview() {
    EventRow()
}