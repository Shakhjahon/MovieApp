package com.example.movieapp.prsenation.screens.search_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.base.model.ResponseStatus
import com.example.movieapp.domain.use_cases.search.GetMovieSearchUseCases
import com.example.movieapp.prsenation.models.mappers.toUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    val getMovieSearchUseCases: GetMovieSearchUseCases
) : ViewModel() {

    private val startSearch = MutableStateFlow("")

    private val _uiState: MutableStateFlow<SearchUiState> =
        MutableStateFlow(SearchUiState.Install)
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    init {
        fetchSearch(startSearch.value)
    }

    fun fetchSearch(textQuery: String) {
        startSearch.value = textQuery
        _uiState.value = SearchUiState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val search = getMovieSearchUseCases(query = textQuery)
            if (search.status == ResponseStatus.SUCCESS) {
                search.data?.let { search ->
                    _uiState.value = SearchUiState.Loaded(
                        searchLoaded = search.sortedBy { it.movieTitle }.map { it.toUi() }.toImmutableList(),
                        query = textQuery,
                    )
                }
            } else {
                _uiState.value = SearchUiState.Error("something went wrong")
            }
        }
    }
}