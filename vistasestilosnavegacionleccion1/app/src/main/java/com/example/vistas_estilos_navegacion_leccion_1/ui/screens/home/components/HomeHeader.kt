package com.example.vistas_estilos_navegacion_leccion_1.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vistas_estilos_navegacion_leccion_1.R
import com.example.vistas_estilos_navegacion_leccion_1.ui.theme.Orange100

@Composable
fun HomeHeader(
    userEmail: String = "",
    navigateToLogin: () -> Unit = {},
    navigateToUserDetails: () -> Unit = {},
) {
    var showDialog by remember { mutableStateOf(false) }

    LogoutConfirmationAlertDialog(
        showDialog = showDialog,
        onConfirm = {
            showDialog = false
            navigateToLogin()
        },
        onDismiss = {
            showDialog = false
        }
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Current location",
                color = Color.Gray
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    Icons.Rounded.LocationOn,
                    contentDescription = "Location icon",
                    modifier = Modifier.size(16.dp),
                    tint = Orange100
                )
                Text(text = "Surakarta, USA", fontWeight = FontWeight.Bold)
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextButton(onClick = navigateToUserDetails) {
                Text(
                    text = userEmail,
                    fontSize = 12.sp
                )
            }
            Image(
                painter = painterResource(id = R.drawable.user_avatar),
                contentDescription = "User avatar"
            )
            TextButton(onClick = { showDialog = true }) {
                Text(text = "Logout", color = Color.Red)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeHeaderPreview() {
    HomeHeader()
}