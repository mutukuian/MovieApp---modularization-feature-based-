package com.example.multimoduleapp.di

import com.example.multimoduleapp.navigation.NavigationProvider
import com.feature.movie.ui.navigation.MovieApi
import com.feature.movie_details.ui.navigation.MovieDetailsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Provides
    fun providesNavigationProvider(movieApi: MovieApi,movieDetailsApi: MovieDetailsApi):NavigationProvider{
        return NavigationProvider(movieApi,movieDetailsApi)
    }

}