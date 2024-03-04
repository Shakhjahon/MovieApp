package com.example.movieapp.prsenation.screens.details_screen

import com.example.movieapp.prsenation.models.deteils_ui.MovieResponseDetailsUi
import javax.annotation.concurrent.Immutable

sealed class DetailsUiState {

    data class Success(
        val movieDetails: MovieResponseDetailsUi
    ) : DetailsUiState()

    data object Loading : DetailsUiState()

    @Immutable
    data class Error(
        val error: String = String()
    ) : DetailsUiState()
}