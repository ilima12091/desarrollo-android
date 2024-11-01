package com.example.pokedex.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.pokedex.ui.components.PokemonDataRow
import com.example.pokedex.ui.components.TextChip
import com.example.pokedex.ui.utils.getColorFromType
import com.example.pokedex.ui.viewModels.PokemonDetailsViewModel

@Composable
fun PokemonDetailsScreen(
    pokemonId: String?,
    viewModel: PokemonDetailsViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val pokemonDetails = uiState.pokemonDetails
    val showFrontSprite = uiState.showFrontSprite
    val isLoading = uiState.isLoading

    LaunchedEffect(pokemonId) {
        pokemonId?.let { viewModel.fetchPokemonDetails(it) }
    }

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(getColorFromType(pokemonDetails?.types?.getOrNull(0)?.type?.name ?: "")),
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 160.dp)
                    .clip(RoundedCornerShape(
                        topStart = 40.dp,
                        topEnd = 40.dp
                    ))
                    .background(Color.White)
                    .padding(horizontal = 16.dp)
                    .padding(top = 40.dp)
                    .fillMaxHeight()
            ) {
                item {
                    Text(
                        text = pokemonDetails?.name?.replaceFirstChar { it.uppercase() } ?: "",
                        fontSize = 40.sp,
                        modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                    )
                    LazyRow (
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
                    ) {
                        items(pokemonDetails?.types ?: emptyList()) { type ->
                            TextChip(
                                text = type.type.name.replaceFirstChar { it.uppercase() },
                                color = getColorFromType(type.type.name)
                            )
                        }
                    }
                }
                item {
                    PokemonDataRow(
                        label = "Height",
                        value = "${pokemonDetails?.height ?: 0} dm"
                    )
                    PokemonDataRow(
                        label = "Weight",
                        value = "${pokemonDetails?.weight ?: 0} hg"
                    )
                    Text(
                        text = "Stats",
                        fontSize = 28.sp,
                        modifier = Modifier.padding(vertical = 16.dp),
                        fontWeight = FontWeight.SemiBold
                    )
                }
                items(pokemonDetails?.stats ?: emptyList()) { pokemonStat ->
                    PokemonDataRow(
                        label = pokemonStat.stat.name.replaceFirstChar { it.uppercase() },
                        value = pokemonStat.baseStat.toString()
                    )
                }
                item {
                    Text(
                        text = "Moves",
                        fontSize = 28.sp,
                        modifier = Modifier.padding(top = 16.dp),
                        fontWeight = FontWeight.SemiBold
                    )
                    LazyHorizontalGrid (
                        rows = GridCells.Fixed(2),
                        modifier = Modifier
                            .padding(vertical = 16.dp)
                            .height(80.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(pokemonDetails?.moves ?: emptyList()) { pokemonMove ->
                            TextChip(
                                text = pokemonMove.move.name.replaceFirstChar { it.uppercase() },
                                color = getColorFromType(pokemonDetails?.types?.get(0)?.type?.name ?: ""),
                                modifier = Modifier.defaultMinSize(minWidth = 160.dp)
                            )
                        }
                    }
                }
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                AsyncImage(
                    model = if (showFrontSprite) pokemonDetails?.sprites?.frontDefault ?: "" else pokemonDetails?.sprites?.backDefault ?: "",
                    contentDescription = "Pokemon",
                    modifier = Modifier
                        .height(220.dp)
                        .width(220.dp)
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(getColorFromType(pokemonDetails?.types?.getOrNull(0)?.type?.name ?: ""))
                        .clickable {
                            viewModel.toggleSprite()
                        },
                    contentScale = ContentScale.FillHeight
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailsScreenPreview() {
    PokemonDetailsScreen("bulbasaur")
}