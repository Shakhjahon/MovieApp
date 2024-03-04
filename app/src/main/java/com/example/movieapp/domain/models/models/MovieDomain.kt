package com.example.movieapp.domain.models.models

import java.io.Serializable

data class MovieDomain(
    val movieAdult: Boolean,
    val movieBackdropPath: String,
    val movieGenreIds: List<Int>,
    val movieId: Int,
    val movieOriginalLanguage: String,
    val movieOriginalTitle: String,
    val movieOverview: String,
    val moviePopularity: Double,
    val moviePosterPath: String,
    val movieReleaseDomain: String,
    val movieTitle: String,
    val movieVoteAverage: Double,
    val movieVoteCount: Int,
): Serializable {
    companion object {
        val unknown = MovieDomain(
            movieAdult = false,
            movieBackdropPath = "",
            movieId = 0,
            movieGenreIds = listOf(0),
            movieOriginalLanguage = "",
            movieOriginalTitle = "",
            movieOverview = "",
            moviePopularity = 0.0,
            moviePosterPath = "",
            movieReleaseDomain = "",
            movieTitle = "",
            movieVoteAverage = 0.0,
            movieVoteCount = 0,
        )
    }
}
