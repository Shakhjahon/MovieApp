package com.example.movieapp.domain.use_cases.playing

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.models.MovieDomain

interface GetMoviePlayingUseCases {
    suspend operator fun invoke(): ResultStatus<List<MovieDomain>>
}