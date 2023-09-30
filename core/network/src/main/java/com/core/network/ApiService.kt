package com.core.network

import com.core.network.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

//https://api.themoviedb.org/3/search/movie?query=Harry&api_key=d48dbbc8b70327df2e30768aa16ef1c9

    @GET("3/search/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey:String,
        @Query("query") q:String
    ): MovieListResponse

}