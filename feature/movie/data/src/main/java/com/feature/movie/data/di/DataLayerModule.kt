package com.feature.movie.data.di

import com.core.network.data_providers.MovieDataProviders
import com.feature.movie.data.repository.MoviesRepositoryImpl
import com.feature.movie.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {

    @Provides
    fun provideMovieRepository(movieDataProviders: MovieDataProviders):MoviesRepository{
        return MoviesRepositoryImpl(movieDataProviders)
    }


}