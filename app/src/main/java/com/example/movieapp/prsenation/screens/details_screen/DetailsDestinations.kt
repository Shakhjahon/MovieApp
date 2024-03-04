package com.example.movieapp.prsenation.screens.details_screen

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.movieapp.prsenation.navigation.Destinations

object DetailsDestinations: Destinations {
    override val route: String get() = "details_screen"

    const val movieId = "movieId"
    val routeWithArgs = "$route/{$movieId}"

    val arguments = listOf(
        navArgument(movieId) {type = NavType.IntType}
    )
}