package com.example.movieapp.domain.use_cases.popular

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.models.MovieDomain

interface GetMoviePopularUseCases {
    suspend operator fun invoke(): ResultStatus<List<MovieDomain>>
}