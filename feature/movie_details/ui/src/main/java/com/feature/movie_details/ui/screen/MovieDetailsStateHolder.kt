package com.feature.movie_details.ui.screen

import com.feature.movie_details.domain.model.MovieDetails

data class MovieDetailsStateHolder(
    val isLoading:Boolean = false,
    val data:MovieDetails ?= null,
    val error:String =""
)
