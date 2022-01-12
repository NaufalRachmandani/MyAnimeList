package com.naufal.myanimelist.presentation.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.naufal.myanimelist.presentation.components.AnimeList
import com.naufal.myanimelist.presentation.components.SearchBar
import com.naufal.myanimelist.presentation.destinations.AnimeDetailScreenDestination
import com.naufal.myanimelist.ui.theme.MyAnimeListTheme
import com.naufal.myanimelist.ui.theme.Primary
import com.naufal.myanimelist.ui.theme.PrimaryLight
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun HomeScreen(navigator: DestinationsNavigator, viewModel: HomeViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = PrimaryLight)
                    .padding(start = 4.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                onSearchClick = {},
                onFavoriteClick = {}
            )
            AnimeList(list = state.topAnimeList) {
                navigator.navigate(
                    AnimeDetailScreenDestination(
                        anime = it
                    )
                )
            }
        }
        if (state.error.isNotBlank()) {
            Toast.makeText(
                context,
                state.error,
                Toast.LENGTH_SHORT
            ).show()
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
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

    }
}
