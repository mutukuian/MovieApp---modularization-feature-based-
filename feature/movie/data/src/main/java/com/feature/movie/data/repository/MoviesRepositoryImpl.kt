package com.feature.movie.data.repository

import com.core.network.data_providers.MovieDataProviders
import com.feature.movie.data.mapper.toDomainMovieList
import com.feature.movie.domain.model.Movie
import com.feature.movie.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val dataProviders: MovieDataProviders
) : MoviesRepository {

    override suspend fun getMovies(apiKey: String, q: String): List<Movie> {
        return dataProviders.getMovieList(apiKey, q).toDomainMovieList()
    }
}