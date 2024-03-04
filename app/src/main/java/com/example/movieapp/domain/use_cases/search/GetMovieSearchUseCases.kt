package com.example.movieapp.domain.use_cases.search

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.models.MovieDomain

interface GetMovieSearchUseCases {
    suspend operator fun invoke(query: String): ResultStatus<List<MovieDomain>>
}