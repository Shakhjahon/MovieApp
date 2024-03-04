package com.example.movieapp.domain.use_cases.up_coming

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.models.MovieDomain
import com.example.movieapp.domain.repository.GetCurrentMovieRepository

class GetMovieUpComingUseCasesImpl(
    private val repository: GetCurrentMovieRepository
): GetMovieUpComingUseCases {
    override suspend fun invoke(): ResultStatus<List<MovieDomain>> {
        val response = repository.getCurrentMovieUpComing()

        return ResultStatus(
            status = response.status,
            data = response.data,
            errorThrowable = response.errorThrowable
        )
    }
}