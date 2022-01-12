package com.naufal.myanimelist.presentation.anime_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufal.core.common.Resource
import com.naufal.core.domain.model.anime.Anime
import com.naufal.core.domain.use_case.CheckFavoriteUseCase
import com.naufal.core.domain.use_case.DeleteAnimeUseCase
import com.naufal.core.domain.use_case.GetAnimeUseCase
import com.naufal.core.domain.use_case.InsertAnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
    private val getAnimeUseCase: GetAnimeUseCase,
    private val insertAnimeUseCase: InsertAnimeUseCase,
    private val deleteAnimeUseCase: DeleteAnimeUseCase,
    private val checkFavoriteUseCase: CheckFavoriteUseCase
) :
    ViewModel() {
    private val _state = mutableStateOf(AnimeDetailScreenState())
    val state: State<AnimeDetailScreenState> = _state

    private val _isFav = MutableLiveData<Boolean>()
    val isFav: LiveData<Boolean> = _isFav

    fun getAnime(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getAnimeUseCase(id).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        Log.i("AnimeDetailViewModel", "getAnime: success")
                        _state.value = AnimeDetailScreenState(
                            anime = result.data ?: Anime(),
                            isFavorite = isFav.value ?: false
                        )
                    }
                    is Resource.Error -> {
                        Log.i("AnimeDetailViewModel", "getAnime: error ${result.message}")
                        _state.value =
                            AnimeDetailScreenState(
                                error = result.message ?: "An Unexpected error occured",
                                anime = state.value.anime,
                                isFavorite = state.value.isFavorite
                            )
                    }
                    is Resource.Loading -> {
                        Log.i("AnimeDetailViewModel", "getAnime: loading")
                        _state.value = AnimeDetailScreenState(
                            isLoading = true, anime = state.value.anime,
                            isFavorite = state.value.isFavorite
                        )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

    fun insertAnime(anime: Anime) {
        viewModelScope.launch(Dispatchers.IO) {
            if (anime.malId != null && anime.malId != 0) {
                insertAnimeUseCase(anime)
                _state.value =
                    AnimeDetailScreenState(
                        message = "Success insert anime to favorite",
                        anime = state.value.anime,
                        isFavorite = state.value.isFavorite
                    )
                isInFavorite(anime.malId ?: 0)
            } else {
                _state.value =
                    AnimeDetailScreenState(
                        message = "Failed insert anime to favorite",
                        anime = state.value.anime,
                        isFavorite = state.value.isFavorite
                    )
            }
        }
    }

    fun deleteAnime(anime: Anime) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAnimeUseCase(anime)
            _state.value =
                AnimeDetailScreenState(
                    message = "Success delete anime from favorite",
                    anime = state.value.anime,
                    isFavorite = state.value.isFavorite
                )
            isInFavorite(anime.malId ?: 0)
        }
    }

    fun isInFavorite(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            checkFavoriteUseCase(id).onStart {
            }.catch { e ->
                Log.i("AnimeDetailViewModel", e.toString())
                _state.value = AnimeDetailScreenState(isFavorite = false, anime = state.value.anime)
            }.collect {
                Log.i("AnimeDetailViewModel", "is in favorite $id = $it")
                _state.value = AnimeDetailScreenState(isFavorite = it, anime = state.value.anime)
            }
        }
    }
}