package com.example.movieapp.domain.models.details_domain


import com.example.movieapp.data.models.details_data.SpokenLanguageDetailsDomein
import com.example.movieapp.domain.models.DetailsDomein.GenreDetailsDomein

data class MovieResponseDetailsDomein(
    val adult: Boolean,
    val backdropPath: String?,
    val budget: Int,
    val genres: List<GenreDetailsDomein>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompanyDetailsDomein>,
    val productionCountries: List<ProductionCountryDetailsDomein>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguageDetailsDomein>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)