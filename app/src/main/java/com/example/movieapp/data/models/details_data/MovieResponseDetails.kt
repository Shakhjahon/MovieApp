package com.example.movieapp.data.models.details_data


import com.google.gson.annotations.SerializedName

data class MovieResponseDetails(
    @SerializedName("adult")
    val movieAdult: Boolean,
    @SerializedName("backdrop_path")
    val movieBackdropPath: String?,
    @SerializedName("budget")
    val movieBudget: Int,
    @SerializedName("genres")
    val movieGenres: List<GenreDetailsData>,
    @SerializedName("homepage")
    val movieHomepage: String,
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("imdb_id")
    val movieImdbId: String,
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
    @SerializedName("production_companies")
    val movieProductionCompanies: List<ProductionCompanyDetailsData>,
    @SerializedName("production_countries")
    val movieProductionCountries: List<ProductionCountryDetailsData>,
    @SerializedName("release_date")
    val movieReleaseDate: String,
    @SerializedName("revenue")
    val movieRevenue: Int,
    @SerializedName("runtime")
    val movieRuntime: Int,
    @SerializedName("spoken_languages")
    val movieSpokenLanguages: List<SpokenLanguageDetailsData>,
    @SerializedName("status")
    val movieStatus: String,
    @SerializedName("tagline")
    val movieTagline: String,
    @SerializedName("title")
    val movieTitle: String,
    @SerializedName("video")
    val movieVideo: Boolean,
    @SerializedName("vote_average")
    val movieVoteAverage: Double,
    @SerializedName("vote_count")
    val movieVoteCount: Int
)