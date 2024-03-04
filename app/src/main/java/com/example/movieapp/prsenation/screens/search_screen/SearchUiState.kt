package com.example.movieapp.prsenation.screens.search_screen

import com.example.movieapp.prsenation.models.models.MovieModelUi
import kotlinx.collections.immutable.ImmutableList
import javax.annotation.concurrent.Immutable

@Immutable
sealed class SearchUiState {

    data object Install : SearchUiState()

    @Immutable
    data class Loaded(
        val searchLoaded: ImmutableList<MovieModelUi>,
        val query: String,
    ) : SearchUiState()

    data object Loading : SearchUiState()

    @Immutable
    data class Error(
        val error: String = String()
    ) : SearchUiState()
}