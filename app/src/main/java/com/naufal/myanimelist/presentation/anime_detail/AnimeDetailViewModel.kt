package com.naufal.myanimelist.presentation.anime_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufal.core.common.Resource
import com.naufal.core.domain.model.anime.Anime
import com.naufal.core.domain.use_case.GetAnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(private val getAnimeUseCase: GetAnimeUseCase) :
    ViewModel() {
    private val _state = mutableStateOf(AnimeDetailScreenState())
    val state: State<AnimeDetailScreenState> = _state

    private val anime: Anime? = null

    fun getAnime(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getAnimeUseCase(id).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        Log.i("AnimeDetailViewModel", "getAnime: success")
                        _state.value =
                            AnimeDetailScreenState(anime = result.data ?: Anime())
                    }
                    is Resource.Error -> {
                        Log.i("AnimeDetailViewModel", "getAnime: error ${result.message}")
                        _state.value =
                            AnimeDetailScreenState(
                                error = result.message ?: "An Unexpected error occured",
                                anime = result.data ?: Anime()
                            )
                    }
                    is Resource.Loading -> {
                        Log.i("AnimeDetailViewModel", "getAnime: loading")
                        _state.value =
                            AnimeDetailScreenState(isLoading = true, anime = result.data ?: Anime())
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}