package com.naufal.myanimelist.presentation.anime_detail

import com.naufal.core.domain.model.anime_list.Anime

data class AnimeDetailScreenState(
    val anime: Anime = Anime(),
    val error: String = "",
    val isLoading: Boolean = false
)
