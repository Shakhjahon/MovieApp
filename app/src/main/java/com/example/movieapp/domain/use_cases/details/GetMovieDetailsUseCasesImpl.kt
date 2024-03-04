package com.example.movieapp.domain.use_cases.details

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.details_domain.MovieResponseDetailsDomein
import com.example.movieapp.domain.repository.GetCurrentMovieRepository

class GetMovieDetailsUseCasesImpl(
    private val repository: GetCurrentMovieRepository,
    ): GetMovieDetailsUseCases {
    override suspend fun invoke(movieId: Int): ResultStatus<MovieResponseDetailsDomein> {
        val response = repository.getCurrentMovieDetails(movieId = movieId)

        return ResultStatus(
            status = response.status,
            data = response.data,
            errorThrowable = response.errorThrowable,
        )
    }
}