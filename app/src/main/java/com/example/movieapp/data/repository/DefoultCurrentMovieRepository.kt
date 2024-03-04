package com.example.movieapp.data.repository

import com.example.movieapp.data.base.BaseDataSource
import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.data.mappers.toDomain
import com.example.movieapp.data.remote.MovieService
import com.example.movieapp.domain.models.details_domain.MovieResponseDetailsDomein
import com.example.movieapp.domain.models.models.MovieDomain
import com.example.movieapp.domain.repository.GetCurrentMovieRepository

class DefoultCurrentMovieRepository(
    private val service: MovieService,
) : GetCurrentMovieRepository, BaseDataSource() {

    //Popular
    override suspend fun getCurrentMoviePopular(): ResultStatus<List<MovieDomain>> {
        val response = invokeResponseRequest {
            service.getAllMoviePopular()
        }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.movieDataList?.map { it.toDomain() }
        )
    }

    //Top Rated
    override suspend fun getCurrentMovieTopRated(): ResultStatus<List<MovieDomain>> {
        val response = invokeResponseRequest {
            service.getAllMovieTopRated()
        }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.movieDataList?.map { it.toDomain() }
        )
    }

    //playing
    override suspend fun getCurrentMoviePlaying(): ResultStatus<List<MovieDomain>> {
        val response = invokeResponseRequest {
            service.getAllMoviePlaying()
        }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.movieDataList?.map { it.toDomain() }
        )
    }

    //UpComing
    override suspend fun getCurrentMovieUpComing(): ResultStatus<List<MovieDomain>> {
        val response = invokeResponseRequest {
            service.getAllMovieUpComing()
        }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.movieDataList?.map { it.toDomain() }
        )
    }

    override suspend fun getCurrentMovieDetails(movieId: Int): ResultStatus<MovieResponseDetailsDomein> {
        val response = invokeResponseRequest {
            service.getMovieDetails(movieId = movieId)
        }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.toDomain()
        )
    }

    override suspend fun getCurrentMovieSearch(query: String): ResultStatus<List<MovieDomain>> {
        val response = invokeResponseRequest {
            service.searchByQuery(textQuery = query)
        }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.movieDataList?.map { it.toDomain() }
        )
    }
}