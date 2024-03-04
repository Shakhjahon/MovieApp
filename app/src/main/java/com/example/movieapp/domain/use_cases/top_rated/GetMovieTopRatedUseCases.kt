package com.example.movieapp.domain.use_cases.top_rated

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.models.MovieDomain

interface GetMovieTopRatedUseCases {
    suspend operator fun invoke(): ResultStatus<List<MovieDomain>>
}