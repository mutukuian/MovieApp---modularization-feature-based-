package com.feature.movie_details.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvents
import com.feature.movie_details.domain.use_case.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel(){

    private val _movieDetails = mutableStateOf(MovieDetailsStateHolder())
    val movieDetails: State<MovieDetailsStateHolder> get() = _movieDetails



    init {
        savedStateHandle.getLiveData<String>("id").observeForever {
            it?.let {
                getMovieDetails(it,"d48dbbc8b70327df2e30768aa16ef1c9")
            }
        }
    }


    fun getMovieDetails(id:String,apiKey:String){
        getMovieDetailsUseCase(id, apiKey).onEach {
            when(it){
                is UiEvents.Loading ->{
                    _movieDetails.value = MovieDetailsStateHolder(isLoading = true)
                }
                is UiEvents.Error ->{
                    _movieDetails.value = MovieDetailsStateHolder(error = it.message.toString())
                }
                is UiEvents.Success ->{
                    _movieDetails.value = MovieDetailsStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}