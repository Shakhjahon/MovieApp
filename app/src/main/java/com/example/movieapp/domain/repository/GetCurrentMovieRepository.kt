package com.example.movieapp.domain.repository

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.details_domain.MovieResponseDetailsDomein
import com.example.movieapp.domain.models.models.MovieDomain

interface GetCurrentMovieRepository {

    //Popular
    suspend fun getCurrentMoviePopular(): ResultStatus<List<MovieDomain>>

    //Top Rated
    suspend fun getCurrentMovieTopRated(): ResultStatus<List<MovieDomain>>

    //playing
    suspend fun getCurrentMoviePlaying(): ResultStatus<List<MovieDomain>>

    //UpComing
    suspend fun getCurrentMovieUpComing(): ResultStatus<List<MovieDomain>>

    //Details
    suspend fun getCurrentMovieDetails(movieId: Int): ResultStatus<MovieResponseDetailsDomein>

    suspend fun getCurrentMovieSearch(query: String): ResultStatus<List<MovieDomain>>
}