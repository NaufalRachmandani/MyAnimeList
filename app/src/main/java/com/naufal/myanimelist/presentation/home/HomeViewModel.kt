package com.naufal.myanimelist.presentation.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufal.core.common.Resource
import com.naufal.core.domain.use_case.GetAnimeTopUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAnimeTopUseCase: GetAnimeTopUseCase
) : ViewModel() {

    private val _state = mutableStateOf(HomeScreenState())
    val state: State<HomeScreenState> = _state

    init {
        getAnimeTop()
    }

    fun getAnimeTop() {
        viewModelScope.launch(Dispatchers.IO) {
            getAnimeTopUseCase().onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        Log.i("HomeViewModel", "getAnimeTop: success")
                        _state.value =
                            HomeScreenState(topAnimeList = result.data ?: mutableListOf())
                    }
                    is Resource.Error -> {
                        Log.i("HomeViewModel", "getAnimeTop: error ${result.message}")
                        _state.value =
                            HomeScreenState(error = result.message ?: "An Unexpected error occured", topAnimeList = state.value.topAnimeList)
                    }
                    is Resource.Loading -> {
                        Log.i("HomeViewModel", "getAnimeTop: loading")
                        _state.value = HomeScreenState(isLoading = true, topAnimeList = state.value.topAnimeList)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}