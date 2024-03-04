package com.example.movieapp.data.models.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieResultsDataModel(
    @SerializedName("adult")
    val movieAdult: Boolean,
    @SerializedName("backdrop_path")
    val movieBackdropPath: String,
    @SerializedName("genre_ids")
    val movieGenreIds: List<Int>,
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("original_language")
    val movieOriginalLanguage: String,
    @SerializedName("original_title")
    val movieOriginalTitle: String,
    @SerializedName("overview")
    val movieOverview: String,
    @SerializedName("popularity")
    val moviePopularity: Double,
    @SerializedName("poster_path")
    val moviePosterPath: String,
    @SerializedName("release_date")
    val movieReleaseDate: String,
    @SerializedName("title")
    val movieTitle: String,
    @SerializedName("vote_average")
    val movieVoteAverage: Double,
    @SerializedName("vote_count")
    val movieVoteCount: Int,
) : Serializable {
    companion object {
        val unknown = MovieResultsDataModel(
        movieAdult = false,
        movieBackdropPath = "",
        movieId = 0,
        movieGenreIds = listOf(0),
        movieOriginalLanguage = "",
        movieOriginalTitle = "",
        movieOverview = "",
        moviePopularity = 0.0,
        moviePosterPath = "",
        movieReleaseDate = "",
        movieTitle = "",
        movieVoteAverage = 0.0,
        movieVoteCount = 0,
        )
    }
}