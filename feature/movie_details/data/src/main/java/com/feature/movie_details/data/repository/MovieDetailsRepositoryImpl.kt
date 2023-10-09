package com.feature.movie_details.data.repository

import com.core.network.data_providers.MovieDataProviders
import com.feature.movie_details.data.mapper.toDomain
import com.feature.movie_details.domain.model.MovieDetails
import com.feature.movie_details.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val movieDataProviders: MovieDataProviders
) :MovieDetailsRepository{

    override suspend fun getMovieDetails(id: String, apiKey: String): MovieDetails {
        return movieDataProviders.getMovieDetails(id, apiKey).toDomain()
    }
}