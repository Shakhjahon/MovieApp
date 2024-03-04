package com.example.movieapp.prsenation.screens.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.base.model.ResponseStatus
import com.example.movieapp.prsenation.models.mappers.toUi
import com.example.movieapp.domain.use_cases.playing.GetMoviePlayingUseCases
import com.example.movieapp.domain.use_cases.popular.GetMoviePopularUseCases
import com.example.movieapp.domain.use_cases.top_rated.GetMovieTopRatedUseCases
import com.example.movieapp.domain.use_cases.up_coming.GetMovieUpComingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getMoviePopularUseCases: GetMoviePopularUseCases,
    private val getMovieTopRatedUseCases: GetMovieTopRatedUseCases,
    private val getMoviePlayingUseCases: GetMoviePlayingUseCases,
    private val getMovieUpComingUseCases: GetMovieUpComingUseCases,
) : ViewModel() {

    private val _uiState: MutableStateFlow<MainScreenUiState> =
        MutableStateFlow(MainScreenUiState.Loading)
    val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    private val handle = CoroutineExceptionHandler { _, throwable -> }

    init {
        fetchMovie()
    }

    fun fetchMovie() {
        viewModelScope.launch(handle + Dispatchers.IO) {
            val popularResponse = getMoviePopularUseCases()
            val topRatedResponse = getMovieTopRatedUseCases()
            val playingResponse = getMoviePlayingUseCases()
            val upComingResponse = getMovieUpComingUseCases()

            if (popularResponse.status == ResponseStatus.SUCCESS &&
                topRatedResponse.status == ResponseStatus.SUCCESS &&
                playingResponse.status == ResponseStatus.SUCCESS &&
                upComingResponse.status == ResponseStatus.SUCCESS
            ) {
                popularResponse.data?.let { popular ->
                    upComingResponse.data?.let { upComing ->
                        playingResponse.data?.let { playing ->
                            topRatedResponse.data?.let { topRated ->
                                _uiState.update {
                                    MainScreenUiState.Loaded(
                                        moviePopular = popular.map { it.toUi() }.toImmutableList(),
                                        moviePlaying = playing.map { it.toUi() }.toImmutableList(),
                                        movieTopRated = topRated.map { it.toUi() }
                                            .toImmutableList(),
                                        movieUpComing = upComing.map { it.toUi() }
                                            .toImmutableList(),
                                    )
                                }
                            }
                        }
                    }
                }
            } else {
                _uiState.tryEmit(
                    MainScreenUiState.Error("something went wrong")
                )
            }
        }
    }
}
