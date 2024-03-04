package com.example.movieapp.domain.use_cases.up_coming

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.models.MovieDomain

interface GetMovieUpComingUseCases {
    suspend operator fun invoke(): ResultStatus<List<MovieDomain>>
}