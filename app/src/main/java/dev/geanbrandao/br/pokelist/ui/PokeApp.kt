package dev.geanbrandao.br.pokelist.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@ExperimentalFoundationApi
@Composable
fun PokeApp() {
    val navHostController = rememberNavController()
    NavGraph(
        navController = navHostController,
    )
}