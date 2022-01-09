package com.naufal.myanimelist.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.naufal.core.domain.model.Anime
import com.naufal.myanimelist.presentation.components.AnimeItem

@Composable
fun AnimeTopList(list: List<Anime>, onAnimeItemClick: (Anime) -> Unit) {
    // Remember our own LazyListState
    val listState = rememberLazyListState()
    LazyColumn(state = listState, verticalArrangement = Arrangement.spacedBy(4.dp),) {
        items(list.size) { index ->
            AnimeItem(list[index]) {
                onAnimeItemClick(it)
            }
        }
    }
}

@Preview
@Composable
fun preview() {
    AnimeTopList(list = listOf(Anime())) {}
}