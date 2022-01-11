package com.naufal.myanimelist.presentation

sealed class Screen(val route: String) {
    object AnimeListScreen: Screen("anime_list")
    object AnimeDetailScreen: Screen("anime_detail")
    object AnimeSearchScreen: Screen("anime_search")
}
