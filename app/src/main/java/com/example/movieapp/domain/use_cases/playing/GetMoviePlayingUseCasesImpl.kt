package com.example.movieapp.domain.use_cases.playing

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.models.MovieDomain
import com.example.movieapp.domain.repository.GetCurrentMovieRepository

class GetMoviePlayingUseCasesImpl(
    private val repository: GetCurrentMovieRepository
) : GetMoviePlayingUseCases {
    override suspend fun invoke(): ResultStatus<List<MovieDomain>> {
        val response =  repository.getCurrentMoviePlaying()

        return ResultStatus(
            status = response.status,
            data = response.data,
            errorThrowable = response.errorThrowable,
        )
    }
}