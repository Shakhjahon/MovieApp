package com.example.movieapp.domain.use_cases.top_rated

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.models.MovieDomain
import com.example.movieapp.domain.repository.GetCurrentMovieRepository

class GetMovieTopRatedUseCasesImpl(
    private val repository: GetCurrentMovieRepository,
): GetMovieTopRatedUseCases {
    override suspend fun invoke(): ResultStatus<List<MovieDomain>> {
        val response = repository.getCurrentMovieTopRated()

        return ResultStatus(
            status = response.status,
            data = response.data,
            errorThrowable = response.errorThrowable,
        )
    }
}