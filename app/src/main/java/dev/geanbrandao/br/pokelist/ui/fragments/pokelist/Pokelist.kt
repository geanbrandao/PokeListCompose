package dev.geanbrandao.br.pokelist.ui.fragments.pokelist

import android.os.Bundle
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.geanbrandao.br.pokelist.model.PokemonModel
import dev.geanbrandao.br.pokelist.ui.DestinationsArguments
import dev.geanbrandao.br.pokelist.ui.DestinationsRoutes
import dev.geanbrandao.br.pokelist.ui.items.PokeItem

@ExperimentalFoundationApi
@Composable
fun Pokelist(navController: NavHostController) {
    PokelistContent(navController = navController)
}

@ExperimentalFoundationApi
@Composable
fun PokelistContent(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.background) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(count = 2),
            contentPadding = PaddingValues(all = 8.dp),
        ) {
            items(
                arrayListOf(
                    "Pikachu",
                    "Absol",
                    "Accelgor",
                    "Alakazam",
                    "Pidgey"
                )
            ) { name: String ->
                PokeItem(name = name, onClick = {
                    val argumentPokemonModel = PokemonModel(id = 1, name = name)
                    navController.currentBackStackEntry?.arguments =
                        Bundle().apply {
                            putSerializable(
                                DestinationsArguments.DETAILS_ARGUMENTS,
                                argumentPokemonModel,
                            )
                        }
                    navController.navigate(DestinationsRoutes.DETAILS_ROUTE)
                })
            }
        }
    }
}