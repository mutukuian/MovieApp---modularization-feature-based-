package com.feature.movie_details.data.di

import com.core.network.data_providers.MovieDataProviders
import com.feature.movie_details.data.repository.MovieDetailsRepositoryImpl
import com.feature.movie_details.domain.repository.MovieDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun providesMovieDetailsRepository(movieDataProviders: MovieDataProviders):MovieDetailsRepository{
        return MovieDetailsRepositoryImpl(movieDataProviders)
    }
}