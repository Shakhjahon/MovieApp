package com.example.movieapp.data.remote

import com.example.movieapp.data.models.details_data.MovieResponseDetails
import com.example.movieapp.data.models.models.MovieDataModel
import com.example.movieapp.data.utils.Constants.FETCH_DETAILS_MOVIE
import com.example.movieapp.data.utils.Constants.FETCH_NOW_PLAYING_MOVIE
import com.example.movieapp.data.utils.Constants.FETCH_POPULAR_MOVIE
import com.example.movieapp.data.utils.Constants.FETCH_TOP_RATED_MOVIE
import com.example.movieapp.data.utils.Constants.FETCH_UPCOMING_MOVIE
import com.example.movieapp.data.utils.Constants.GET_MOVIE_SEARCH_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    //Popular
    @GET(FETCH_POPULAR_MOVIE)
    suspend fun getAllMoviePopular(
        @Query("language") language: String = "en"
    ): Response<MovieDataModel>

    //Top Rated
    @GET(FETCH_TOP_RATED_MOVIE)
    suspend fun getAllMovieTopRated(
        @Query("language") language: String = "en"
    ): Response<MovieDataModel>

    //playing
    @GET(FETCH_NOW_PLAYING_MOVIE)
    suspend fun getAllMoviePlaying(
        @Query("language") language: String = "en"
    ): Response<MovieDataModel>

    //UpComing
    @GET(FETCH_UPCOMING_MOVIE)
    suspend fun getAllMovieUpComing(
        @Query("language") language: String = "en"
    ): Response<MovieDataModel>

    //Details
    @GET(FETCH_DETAILS_MOVIE)
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "en"
    ): Response<MovieResponseDetails>

    @GET(GET_MOVIE_SEARCH_ID)
    suspend fun searchByQuery(
        @Query("query") textQuery: String = "en"
        ): Response<MovieDataModel>
}