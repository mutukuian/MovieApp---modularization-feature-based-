package com.feature.movie_details.domain.use_case

import com.core.common.UiEvents
import com.feature.movie_details.domain.model.MovieDetails
import com.feature.movie_details.domain.repository.MovieDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val movieDetailsRepository: MovieDetailsRepository
){

    operator fun invoke(id:String,apiKey:String):Flow<UiEvents<MovieDetails>> = flow {
        emit(UiEvents.Loading())
        emit(UiEvents.Success(movieDetailsRepository.getMovieDetails(id, apiKey)))
    }.catch {
        emit(UiEvents.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}