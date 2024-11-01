package com.example.pokedex.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokedex.ui.components.PokemonListItem
import com.example.pokedex.ui.viewModels.PokemonsListViewModel


@Composable
fun PokemonsListScreen(
    onPokemonClick: (pokemonId: String) -> Unit,
    viewModel: PokemonsListViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val pokemons = uiState.pokemonList
    val isLoading = uiState.isLoading
    val listState = rememberLazyListState()

    val buffer = 4
    val reachedBottom: Boolean by remember {
        derivedStateOf {
            val lastVisibleItem = listState.layoutInfo.visibleItemsInfo.lastOrNull()
            lastVisibleItem?.index != 0 && lastVisibleItem?.index == listState.layoutInfo.totalItemsCount - buffer
        }
    }

    LaunchedEffect(reachedBottom) {
        if (reachedBottom && !isLoading) {
            viewModel.fetchMorePokemons()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
    ) {
        Text("Pokemons", modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp), fontSize = 48.sp)
        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(16.dp),
            state = listState
        ) {
            items(pokemons) {
                PokemonListItem(
                    onPokemonClick,
                    pokemon = it
                )
            }
            if (isLoading) {
                item {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PokemonsListScreenPreview() {
    PokemonsListScreen(
        onPokemonClick = {}
    )
}