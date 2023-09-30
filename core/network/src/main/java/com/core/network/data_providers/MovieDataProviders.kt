package com.core.network.data_providers

import com.core.network.ApiService
import javax.inject.Inject

class MovieDataProviders @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getMovieList(apiKey:String,q:String) = apiService.getMovies(apiKey, q)
}