package com.example.movieapp.domain.use_cases.search

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.models.MovieDomain
import com.example.movieapp.domain.repository.GetCurrentMovieRepository

class GetMovieSearchUseCasesImpl(
    val repository: GetCurrentMovieRepository
): GetMovieSearchUseCases {
    override suspend fun invoke(query: String): ResultStatus<List<MovieDomain>> {
        val response = repository.getCurrentMovieSearch(
            query = query
        )
        return ResultStatus(
            status = response.status,
            data = response.data,
            errorThrowable = response.errorThrowable,
        )
    }
}