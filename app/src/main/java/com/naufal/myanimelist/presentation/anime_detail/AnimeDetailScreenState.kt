package com.naufal.myanimelist.presentation.anime_detail

import com.naufal.core.domain.model.anime.Anime

data class AnimeDetailScreenState(
    val anime: Anime = Anime(),
    val error: String = "",
    val message: String = "",
    val isFavorite: Boolean = false,
    val isLoading: Boolean = false
)
