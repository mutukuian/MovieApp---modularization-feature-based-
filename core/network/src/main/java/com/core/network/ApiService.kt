package com.core.network

import com.core.network.model.MovieListResponse
import com.core.network.model.MovieDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

//https://api.themoviedb.org/3/search/movie?query=Harry&api_key=d48dbbc8b70327df2e30768aa16ef1c9

    @GET("3/search/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey:String,
        @Query("query") q:String
    ): MovieListResponse


    //details
//    https://api.themoviedb.org/3/movie/767?api_key=d48dbbc8b70327df2e30768aa16ef1c9
    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id:String,
        @Query("api_key") apiKey: String
    ):MovieDetailsDTO
}