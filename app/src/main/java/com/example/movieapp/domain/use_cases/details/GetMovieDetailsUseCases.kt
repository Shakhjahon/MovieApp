package com.example.movieapp.domain.use_cases.details

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.details_domain.MovieResponseDetailsDomein

interface GetMovieDetailsUseCases {

    suspend operator fun invoke(movieId: Int): ResultStatus<MovieResponseDetailsDomein>
}