package com.example.movieapp.di

import com.example.movieapp.domain.repository.GetCurrentMovieRepository
import com.example.movieapp.domain.use_cases.details.GetMovieDetailsUseCases
import com.example.movieapp.domain.use_cases.details.GetMovieDetailsUseCasesImpl
import com.example.movieapp.domain.use_cases.playing.GetMoviePlayingUseCases
import com.example.movieapp.domain.use_cases.playing.GetMoviePlayingUseCasesImpl
import com.example.movieapp.domain.use_cases.popular.GetMoviePopularUseCases
import com.example.movieapp.domain.use_cases.popular.GetMoviePopularUseCasesImpl
import com.example.movieapp.domain.use_cases.search.GetMovieSearchUseCases
import com.example.movieapp.domain.use_cases.search.GetMovieSearchUseCasesImpl
import com.example.movieapp.domain.use_cases.top_rated.GetMovieTopRatedUseCases
import com.example.movieapp.domain.use_cases.top_rated.GetMovieTopRatedUseCasesImpl
import com.example.movieapp.domain.use_cases.up_coming.GetMovieUpComingUseCases
import com.example.movieapp.domain.use_cases.up_coming.GetMovieUpComingUseCasesImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    //Popular
    @Provides
    fun provideGetMoviePopularUseCases(
        repository: GetCurrentMovieRepository
    ): GetMoviePopularUseCases = GetMoviePopularUseCasesImpl(
        repository = repository
    )

    //Top Rated
    @Provides
    fun provideGetMovieTopRatedUseCases(
        repository: GetCurrentMovieRepository
    ): GetMovieTopRatedUseCases = GetMovieTopRatedUseCasesImpl(
        repository = repository
    )

    //playing
    @Provides
    fun provideGetMoviePlayingUseCases(
        repository: GetCurrentMovieRepository
    ): GetMoviePlayingUseCases = GetMoviePlayingUseCasesImpl(
        repository = repository
    )

    //UpComing
    @Provides
    fun provideGetMovieUpComingUseCases(
        repository: GetCurrentMovieRepository
    ): GetMovieUpComingUseCases = GetMovieUpComingUseCasesImpl(
        repository = repository
    )

    //Details
    @Provides
    fun provideGetMovieDetailsUseCases(
        repository: GetCurrentMovieRepository
    ): GetMovieDetailsUseCases = GetMovieDetailsUseCasesImpl(
        repository = repository
    )

    //Search
    @Provides
    fun provideGetMovieSearchUseCases(
        repository: GetCurrentMovieRepository
    ): GetMovieSearchUseCases = GetMovieSearchUseCasesImpl(
        repository = repository
    )
}