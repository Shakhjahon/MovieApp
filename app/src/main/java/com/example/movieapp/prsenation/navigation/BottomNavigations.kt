package com.example.movieapp.prsenation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieapp.prsenation.screens.bottom_navigation.BottomScreens
import com.example.movieapp.prsenation.screens.details_screen.DetailsDestinations
import com.example.movieapp.prsenation.screens.details_screen.DetailsScreen
import com.example.movieapp.prsenation.screens.details_screen.DetailsViewModel
import com.example.movieapp.prsenation.screens.main_screen.MainScreen
import com.example.movieapp.prsenation.screens.main_screen.MainScreenViewModel
import com.example.movieapp.prsenation.screens.search_screen.SearchScreen
import com.example.movieapp.prsenation.screens.search_screen.SearchViewModel
import com.example.movieapp.prsenation.screens.watch_screen.WatchScreen

@Composable
fun BottomNavigation(
    navHostController: NavHostController,
    callBackPopBack: () -> Unit,
) {
    val mainScreen = BottomScreens.MainScreen.route
    val searchScreen = BottomScreens.SearchScreen.route
    val saveScreen = BottomScreens.WatchListScreen.route

    NavHost(
        navController = navHostController,
        startDestination = mainScreen
    ) {

        composable(mainScreen) {
            val viewModel: MainScreenViewModel = hiltViewModel()
            val uiState = viewModel.uiState.collectAsState().value
            MainScreen(
                viewModel = viewModel,
                stateFlow = viewModel.uiState,
                callBackPopBack = callBackPopBack,
                onNavigatyInfo = { movieId ->
                    navHostController.navigate("${DetailsDestinations.route}/$movieId")
                },
                navigatySearchScreen = {navHostController.navigate(searchScreen)}
            )
        }
        composable(searchScreen) {
            val viewModel: SearchViewModel = hiltViewModel()
            val uiState = viewModel.uiState.collectAsState().value
            SearchScreen(
                uiStateFlow = viewModel.uiState,
                onValueChange = viewModel::fetchSearch,
                navigateToDetails = { searchId ->
                    navHostController.navigate("${DetailsDestinations.route}/$searchId")
                },
                callBackPopBackState = {navHostController.popBackStack()}
            )
        }
        composable(saveScreen) {
            WatchScreen()
        }
        composable(
            route = DetailsDestinations.routeWithArgs,
            arguments = DetailsDestinations.arguments,
        ) { navBackStackEntry ->
            val movieId = navBackStackEntry.arguments?.getInt(DetailsDestinations.movieId) ?: 0
            val viewModels: DetailsViewModel = hiltViewModel()
            val uiState = viewModels.uiState.collectAsState().value
            DetailsScreen(
                onGetMovieInfo = { viewModels.fetchByIdMovie(movieId) },
                stateFlow = viewModels.uiState,
                onGetMovieMainScreen = { navHostController.popBackStack() }
            )
        }
    }
}