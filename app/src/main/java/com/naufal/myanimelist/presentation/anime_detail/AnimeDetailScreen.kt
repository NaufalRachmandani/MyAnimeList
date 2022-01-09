package com.naufal.myanimelist.presentation.anime_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.naufal.myanimelist.presentation.components.AnimeList
import com.naufal.myanimelist.presentation.components.SearchBar
import com.naufal.myanimelist.presentation.home.HomeViewModel
import com.naufal.myanimelist.ui.theme.*

@Composable
fun AnimeDetailScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val state = viewModel.state.value
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

            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
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
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Boruto Naruto Next generation",
                            color = Color.White,
                            style = toolbarTextStyle,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    backgroundColor = Primary,
                    contentColor = Color.White,
                    elevation = 12.dp,
                    actions = {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "favorite",
                            tint = Color.White
                        )
                    }
                )
            }, content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.White)
                            .padding(4.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(
                            text = "${"Boruto"}: Naruto Next Generation",
                            style = animeTitleTextStyle
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(140.dp)
                                    .background(Primary)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Column(
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(
                                    modifier = Modifier
                                        .background(Primary)
                                        .padding(4.dp),
                                    text = "SCORE",
                                    style = baseTextStyle,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = "8.89",
                                    style = baseTextStyle,
                                )
                            }
                        }

                    }
                }
            })
    }
}