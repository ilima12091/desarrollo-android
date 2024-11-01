package com.example.pokedex.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable()
fun PokemonDataRow(
    label: String,
    value: String
) {
    Row(
        Modifier.fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontSize = 24.sp)
        Text(text = value, fontSize = 24.sp)
    }
}

@Preview
@Composable
fun PokemonDataRowPreview() {
    PokemonDataRow(
        label = "Height",
        value = "7"
    )
}