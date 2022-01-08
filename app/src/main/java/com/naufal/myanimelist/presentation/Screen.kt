package com.naufal.myanimelist.presentation

sealed class Screen(val route: String) {
    object AnimeListScreen: Screen("anime_list")
    object AnimeSearchScreen: Screen("anime_search")
    object AnimeDetailScreen: Screen("anime_detail")
}
