package com.naufal.myanimelist.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.naufal.core.domain.model.Anime
import com.naufal.myanimelist.R
import com.naufal.myanimelist.presentation.components.SearchBar
import com.naufal.myanimelist.presentation.home.components.AnimeTopList
import com.naufal.myanimelist.ui.theme.MyAnimeListTheme
import com.naufal.myanimelist.ui.theme.Primary
import com.naufal.myanimelist.ui.theme.PrimaryLight

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val uiState = viewModel.state
    InitiateUI(
        onSearchClick = {},
        onFavoriteClick = {},
        onAnimeItemCLick = {},
        state = uiState.value,
    )
}

@Composable
fun InitiateUI(
    onSearchClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onAnimeItemCLick: (Anime) -> Unit,
    state: HomeScreenState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        TopSection(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = PrimaryLight)
                .padding(start = 4.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
            onSearchClick = {onSearchClick()},
            onFavoriteClick = {onFavoriteClick()}
        )
        AnimeTopList(list = state.topAnimeList) {
            onAnimeItemCLick(it)
        }
    }
}

@Composable
fun TopSection(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SearchBar(modifier = Modifier
            .weight(1f)
            .clickable { onSearchClick() },
            onValueChanged = {

            })
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            modifier = Modifier
                .size(24.dp)
                .clickable { onFavoriteClick() },
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorite",
            tint = Primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAnimeListTheme {
//        val viewModel = HomeViewModel()
//        InitiateUI(
//            onSearchClick = {},
//            onFavoriteClick = {},
//            onAnimeItemCLick = {},
//            state = ,
//        )
    }
}
