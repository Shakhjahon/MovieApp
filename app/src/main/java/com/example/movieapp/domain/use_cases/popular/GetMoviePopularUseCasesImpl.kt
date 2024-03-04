package com.example.movieapp.domain.use_cases.popular

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.models.MovieDomain
import com.example.movieapp.domain.repository.GetCurrentMovieRepository

class GetMoviePopularUseCasesImpl(
    private val repository: GetCurrentMovieRepository,
) : GetMoviePopularUseCases {
    override suspend fun invoke(): ResultStatus<List<MovieDomain>> {
        val response =  repository.getCurrentMoviePopular()

        return ResultStatus(
            status = response.status,
            data = response.data,
            errorThrowable = response.errorThrowable,
        )
    }
}
