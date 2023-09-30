package com.feature.movie.domain.use_case

import com.core.common.UiEvents
import com.feature.movie.domain.model.Movie
import com.feature.movie.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
){

    operator fun invoke(apiKey:String,q:String) = flow<UiEvents<List<Movie>>> {
        emit(UiEvents.Loading())
        emit(UiEvents.Success(moviesRepository.getMovies(apiKey, q)))
    }.catch {
        emit(UiEvents.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}