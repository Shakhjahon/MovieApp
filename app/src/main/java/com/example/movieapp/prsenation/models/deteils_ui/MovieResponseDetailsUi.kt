package com.example.movieapp.prsenation.models.deteils_ui


data class MovieResponseDetailsUi(
    val adult: Boolean,
    val backdropPath: String,
    val budget: Int,
    val genres: List<GenreDetailsUi>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompanyDetailsUi>,
    val productionCountries: List<ProductionCountryDetailsUi>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguageDetailsUi>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)