package com.feature.movie_details.domain.di

import com.feature.movie_details.domain.repository.MovieDetailsRepository
import com.feature.movie_details.domain.use_case.GetMovieDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun providesGetMovieDetailsUseCase(movieDetailsRepository: MovieDetailsRepository):GetMovieDetailsUseCase{
        return GetMovieDetailsUseCase(movieDetailsRepository)
    }
}