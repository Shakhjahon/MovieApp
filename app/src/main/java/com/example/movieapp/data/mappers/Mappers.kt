package com.example.movieapp.data.mappers

import com.example.movieapp.data.models.details_data.GenreDetailsData
import com.example.movieapp.data.models.details_data.MovieResponseDetails
import com.example.movieapp.data.models.details_data.ProductionCompanyDetailsData
import com.example.movieapp.data.models.details_data.ProductionCountryDetailsData
import com.example.movieapp.data.models.details_data.SpokenLanguageDetailsData
import com.example.movieapp.data.models.details_data.SpokenLanguageDetailsDomein
import com.example.movieapp.data.models.models.MovieResultsDataModel
import com.example.movieapp.data.utils.Constants.POSTER_PATH_URL
import com.example.movieapp.domain.models.DetailsDomein.GenreDetailsDomein
import com.example.movieapp.domain.models.details_domain.MovieResponseDetailsDomein
import com.example.movieapp.domain.models.details_domain.ProductionCompanyDetailsDomein
import com.example.movieapp.domain.models.details_domain.ProductionCountryDetailsDomein
import com.example.movieapp.domain.models.models.MovieDomain

fun MovieResultsDataModel.toDomain() = MovieDomain(
    movieVoteCount = movieVoteCount,
    movieTitle = movieTitle,
    movieVoteAverage = movieVoteAverage,
    movieReleaseDomain = movieReleaseDate,
    moviePosterPath = POSTER_PATH_URL + moviePosterPath,
    moviePopularity = moviePopularity,
    movieOverview = movieOverview,
    movieOriginalTitle = movieOriginalTitle,
    movieId = movieId,
    movieOriginalLanguage = movieOriginalLanguage,
    movieBackdropPath = movieBackdropPath + POSTER_PATH_URL,
    movieAdult = movieAdult,
    movieGenreIds = movieGenreIds,
)

fun MovieResponseDetails.toDomain() = MovieResponseDetailsDomein(
    adult = movieAdult,
    backdropPath = POSTER_PATH_URL + movieBackdropPath,
    budget = movieBudget,
    genres = movieGenres.map { it.toDomain() },
    homepage = movieHomepage,
    id = movieId,
    imdbId = movieImdbId,
    originalLanguage = movieOriginalLanguage,
    originalTitle = movieOriginalTitle,
    overview = movieOverview,
    popularity = moviePopularity,
    posterPath = POSTER_PATH_URL + moviePosterPath,
    productionCompanies = movieProductionCompanies.map { it.toDomain() },
    productionCountries = movieProductionCountries.map { it.toDomain() },
    releaseDate = movieReleaseDate,
    revenue = movieRevenue,
    runtime = movieRuntime,
    spokenLanguages = movieSpokenLanguages.map { it.toDomain() },
    status = movieStatus,
    tagline = movieTagline,
    title = movieTitle,
    video = movieVideo,
    voteAverage = movieVoteAverage,
    voteCount = movieVoteCount,
)

fun GenreDetailsData.toDomain() = GenreDetailsDomein(
    name = movieName, id = movieId
)

fun ProductionCountryDetailsData.toDomain() = ProductionCountryDetailsDomein(
    name = movieName, iso31661 = movieIso31661
)

fun ProductionCompanyDetailsData.toDomain() = ProductionCompanyDetailsDomein(
    id = movieId, originCountry = movieOriginCountry, logoPath = movieLogoPath, name = movieName
)

fun SpokenLanguageDetailsData.toDomain() = SpokenLanguageDetailsDomein(
    englishName = movieEnglishName, name = movieName, iso6391 = movieIso6391
)