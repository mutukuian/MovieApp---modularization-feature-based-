package com.feature.movie.domain.di

import com.feature.movie.domain.repository.MoviesRepository
import com.feature.movie.domain.use_case.GetMovieListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {
    @Provides
    fun providesGetMovieListUseCase(moviesRepository: MoviesRepository):GetMovieListUseCase{
        return GetMovieListUseCase(moviesRepository)
    }
}