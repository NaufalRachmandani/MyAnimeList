package com.naufal.myanimelist.presentation.home

import com.naufal.core.domain.model.anime_list.Anime

data class HomeScreenState(
    val topAnimeList: List<Anime> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
