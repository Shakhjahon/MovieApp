package com.example.movieapp.prsenation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.prsenation.screens.bottom_navigation.BottomDestination
import com.example.movieapp.prsenation.screens.bottom_navigation.BottomScreen
import com.example.movieapp.prsenation.screens.splash_screen.SplashDestination
import com.example.movieapp.prsenation.screens.splash_screen.SplashScreen

@Composable
fun MainNavGraph(
    navHostControllers: NavHostController,
    callBackPopBack: () -> Unit,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navHostControllers,
        startDestination = SplashDestination.route
    ) {

        composable(SplashDestination.route) {
            SplashScreen(
                navigatyController = {
                    navHostControllers.navigate(BottomDestination.route)
                },
            )
        }
        composable(BottomDestination.route) {
            BottomScreen(
                callBackPopBack = callBackPopBack,
            )
        }
    }
}
