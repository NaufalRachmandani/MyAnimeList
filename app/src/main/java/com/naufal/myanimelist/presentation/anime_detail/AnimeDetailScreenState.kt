package com.naufal.myanimelist.presentation.anime_detail

data class AnimeDetailScreenState(
    val message: String = "",
    val isLoading: Boolean = false
)

data class FavoriteState(
    val isFavorite: Boolean = false
)
