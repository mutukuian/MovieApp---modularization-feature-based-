package com.example.multimoduleapp.di

import com.example.multimoduleapp.navigation.NavigationProvider
import com.feature.movie.ui.navigation.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Provides
    fun providesNavigationProvider(movieApi: MovieApi):NavigationProvider{
        return NavigationProvider(movieApi)
    }

}