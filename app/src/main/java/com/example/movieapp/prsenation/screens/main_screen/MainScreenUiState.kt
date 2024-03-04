package com.example.movieapp.prsenation.screens.main_screen

import com.example.movieapp.prsenation.models.models.MovieModelUi
import kotlinx.collections.immutable.ImmutableList
import javax.annotation.concurrent.Immutable

@Immutable
sealed class MainScreenUiState {

    @Immutable
    data class Loaded(
        val moviePopular: ImmutableList<MovieModelUi>,
        val movieUpComing: ImmutableList<MovieModelUi>,
        val moviePlaying: ImmutableList<MovieModelUi>,
        val movieTopRated: ImmutableList<MovieModelUi>,
    ) : MainScreenUiState()

    data object Loading : MainScreenUiState()

    @Immutable
    data class Error(
        val error: String = String()
    ) : MainScreenUiState()
}

