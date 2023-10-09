package com.feature.movie_details.ui.navigation

import com.core.feature_api.FeatureApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface MovieDetailsApi : FeatureApi{

}

class MovieDetailsApiImpl: MovieDetailsApi{
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalMovieDetailsApi.registerGraph(navController, navGraphBuilder)
    }
}