package com.example.movieapp.prsenation.screens.details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.base.model.ResponseStatus
import com.example.movieapp.prsenation.models.mappers.toUi
import com.example.movieapp.domain.use_cases.details.GetMovieDetailsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCases: GetMovieDetailsUseCases
) : ViewModel() {

    private val _uiState: MutableStateFlow<DetailsUiState> =
        MutableStateFlow(DetailsUiState.Loading)
    val uiState: StateFlow<DetailsUiState> = _uiState.asStateFlow()


    fun fetchByIdMovie(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val movieDetails = getMovieDetailsUseCases(movieId = movieId)
            if (movieDetails.status == ResponseStatus.SUCCESS) {
                movieDetails.data?.let { details ->
                    _uiState.update {
                        DetailsUiState.Success(
                            movieDetails = details.toUi()
                        )
                    }
                }
            }
        }
    }
}