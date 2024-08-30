package com.example.proyectoinicial

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectoinicial.ui.theme.ProyectoInicialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoInicialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        LoginLogo(modifier = Modifier.fillMaxWidth())
        OutlinedTextField(modifier = Modifier.fillMaxWidth(), value = "", onValueChange = {}, label = { Text(text = "Email input")})
        OutlinedTextField(modifier = Modifier.fillMaxWidth(), value = "", onValueChange = {}, label = {Text(text = "Password input")})
        Text(text = "Forgot Password?", modifier = Modifier.align(Alignment.End))
        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "LOGIN")
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Don't have an account?")
            Text(text = "Sign-up")
        }
        Text(text = "Or login with", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)) {
            Button(onClick = { /*TODO*/ } ) {
                Icon(painter = painterResource(id = R.drawable.icon_gmail), contentDescription = "Gmail logo")
            }
            Button(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.icon_facebook), contentDescription = "Facebook logo")
            }
        }
    }
}

@Composable
fun LoginLogo(modifier: Modifier = Modifier) {
    Box(modifier = modifier, ) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Login logo",  modifier = Modifier.align(Alignment.Center))
        Text(text = "Log in", modifier = Modifier.align(Alignment.Center))
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ProyectoInicialTheme {
        LoginScreen()
    }
}