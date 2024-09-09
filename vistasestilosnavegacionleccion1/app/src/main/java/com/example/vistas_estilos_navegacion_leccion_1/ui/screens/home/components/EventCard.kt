package com.example.vistas_estilos_navegacion_leccion_1.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vistas_estilos_navegacion_leccion_1.R

@Composable
fun EventCard() {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 16.dp).shadow(4.dp)
    ) {
        EventContent()
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "43 Joined",
                fontSize = 12.sp
            )
            Row {
                Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.user_avatar),
                    contentDescription = "User 1 avatar",
                )
                Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.user_avatar),
                    contentDescription = "User 1 avatar",
                )
                Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.user_avatar),
                    contentDescription = "User 1 avatar",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventCardPreview() {
    EventCard()
}