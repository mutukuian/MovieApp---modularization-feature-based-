package com.feature.movie.domain.repository

import com.feature.movie.domain.model.Movie

interface MoviesRepository {

    suspend fun getMovies(apiKey:String,q:String):List<Movie>
}