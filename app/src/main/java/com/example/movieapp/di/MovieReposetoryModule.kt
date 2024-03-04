package com.example.movieapp.di

import com.example.movieapp.data.remote.MovieService
import com.example.movieapp.data.repository.DefoultCurrentMovieRepository
import com.example.movieapp.domain.repository.GetCurrentMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MovieReposetoryModule {

    @Provides
    fun provideGetCurrentMovieRepository(
        movieService: MovieService
    ): GetCurrentMovieRepository = DefoultCurrentMovieRepository(
        service = movieService
    )

}