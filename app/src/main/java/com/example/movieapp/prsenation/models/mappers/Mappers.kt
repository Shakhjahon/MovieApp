package com.example.movieapp.prsenation.models.mappers

import com.example.movieapp.domain.models.details_domain.ProductionCountryDetailsDomein
import com.example.movieapp.data.models.details_data.SpokenLanguageDetailsDomein
import com.example.movieapp.data.utils.Constants.POSTER_PATH_URL
import com.example.movieapp.domain.models.DetailsDomein.GenreDetailsDomein
import com.example.movieapp.domain.models.details_domain.MovieResponseDetailsDomein
import com.example.movieapp.domain.models.details_domain.ProductionCompanyDetailsDomein
import com.example.movieapp.domain.models.models.MovieDomain
import com.example.movieapp.prsenation.models.deteils_ui.GenreDetailsUi
import com.example.movieapp.prsenation.models.deteils_ui.MovieResponseDetailsUi
import com.example.movieapp.prsenation.models.deteils_ui.ProductionCompanyDetailsUi
import com.example.movieapp.prsenation.models.deteils_ui.ProductionCountryDetailsUi
import com.example.movieapp.prsenation.models.deteils_ui.SpokenLanguageDetailsUi
import com.example.movieapp.prsenation.models.models.MovieModelUi

fun MovieDomain.toUi() = MovieModelUi(
    movieVoteCountUi = movieVoteCount,
    movieTitleUi = movieTitle,
    movieVoteAverageUi = movieVoteAverage,
    movieReleaseUi = movieReleaseDomain,
    moviePosterPathUi = moviePosterPath + POSTER_PATH_URL,
    moviePopularityUi = moviePopularity,
    movieOverviewUi = movieOverview,
    movieOriginalTitleUi = movieOriginalTitle,
    movieIdUi = movieId,
    movieOriginalLanguageUi = movieOriginalLanguage,
    movieBackdropPathUi = movieBackdropPath + POSTER_PATH_URL,
    movieAdultUi = movieAdult,
    movieGenreIdsUi = movieGenreIds,
)

fun MovieResponseDetailsDomein.toUi() = MovieResponseDetailsUi(
    adult = adult,
    backdropPath = backdropPath.orEmpty(),
    budget = budget,
    genres = genres.map { it.toUi() },
    homepage = homepage,
    id = id,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    productionCompanies = productionCompanies.map { it.toUi() },
    productionCountries = productionCountries.map { it.toUi() },
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages.map { it.toUi() },
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun GenreDetailsDomein.toUi() = GenreDetailsUi(
    name = name, id = id
)

fun ProductionCountryDetailsDomein.toUi() = ProductionCountryDetailsUi(
    name = name, iso31661 = iso31661
)

fun ProductionCompanyDetailsDomein.toUi() = ProductionCompanyDetailsUi(
    id = id, originCountry = originCountry, logoPath = logoPath.orEmpty(), name = name
)

fun SpokenLanguageDetailsDomein.toUi() = SpokenLanguageDetailsUi(
    englishName = englishName, name = name, iso6391 = iso6391
)