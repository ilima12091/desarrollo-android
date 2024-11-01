package com.example.pokedex.ui.components

import android.telecom.Call
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pokedex.api.responses.PokemonItem
import com.example.pokedex.ui.utils.getColorFromType

@Composable
fun PokemonListItem(
    onPress: (pokemonId: String) -> Unit,
    pokemon: PokemonItem?
) {
    Row(
        modifier = Modifier
            .height(160.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(getColorFromType(pokemon?.details?.types?.get(0)?.type?.name ?: ""))
            .clickable {
                onPress(pokemon?.name ?: "")
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        AsyncImage(
            model = pokemon?.details?.sprites?.frontDefault,
            contentDescription = "Pokemon",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(140.dp)
        )
        Column {
            Text(
                text = pokemon?.name?.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase() else it.toString()
                } ?: "",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
            LazyRow (
                Modifier.padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(pokemon?.details?.types ?: emptyList()) { type ->
                    TextChip(
                        text = type.type.name,
                        color = Color.Transparent,
                        modifier = Modifier.border(
                            width = 2.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(40.dp)
                        )
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PokemonListItemPreview() {
    PokemonListItem(
        onPress = {},
        pokemon = null
    )
}