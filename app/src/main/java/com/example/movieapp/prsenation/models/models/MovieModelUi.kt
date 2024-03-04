package com.example.movieapp.prsenation.models.models

import com.example.movieapp.domain.models.models.MovieDomain
import java.io.Serializable

data class  MovieModelUi(
    val movieAdultUi: Boolean,
    val movieBackdropPathUi: String,
    val movieGenreIdsUi: List<Int>,
    val movieIdUi: Int,
    val movieOriginalLanguageUi: String,
    val movieOriginalTitleUi: String,
    val movieOverviewUi: String,
    val moviePopularityUi: Double,
    val moviePosterPathUi: String,
    val movieReleaseUi: String,
    val movieTitleUi: String,
    val movieVoteAverageUi: Double,
    val movieVoteCountUi: Int,
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
