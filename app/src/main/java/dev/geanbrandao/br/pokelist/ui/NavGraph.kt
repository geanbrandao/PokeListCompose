package dev.geanbrandao.br.pokelist.ui

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.geanbrandao.br.pokelist.model.PokemonModel
import dev.geanbrandao.br.pokelist.ui.fragments.pokedetails.Pokedetails
import dev.geanbrandao.br.pokelist.ui.fragments.pokelist.Pokelist

object DestinationsRoutes {
    const val LIST_ROUTE = "pokelist"
    const val DETAILS_ROUTE = "pokedetails"
}

object DestinationsArguments {
    const val DETAILS_ARGUMENTS = "pokedetails_arguments"
}

@ExperimentalFoundationApi
@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = DestinationsRoutes.LIST_ROUTE
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(DestinationsRoutes.LIST_ROUTE) {
            Pokelist(navController = navController)
        }

        composable(DestinationsRoutes.DETAILS_ROUTE) {
            val argumentPokemomModel: PokemonModel =
                navController.previousBackStackEntry?.arguments?.getSerializable(
                    DestinationsArguments.DETAILS_ARGUMENTS
                ) as PokemonModel
            Log.d("DEBUG1", argumentPokemomModel.toString())
            Pokedetails(pokemonModel = argumentPokemomModel)
        }

    }
}