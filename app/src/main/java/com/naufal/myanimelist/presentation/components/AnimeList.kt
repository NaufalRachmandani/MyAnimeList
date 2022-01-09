package com.naufal.myanimelist.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.naufal.core.domain.model.Anime
import com.naufal.myanimelist.R
import com.naufal.myanimelist.ui.theme.*
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun AnimeList(list: List<Anime>, onAnimeItemClick: (Anime) -> Unit) {
    val listState = rememberLazyListState()
    LazyColumn(
        modifier = Modifier.background(color = Color.White),
        state = listState,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(top = 8.dp)
    ) {
        items(list.size) { index ->
            AnimeItem(list[index]) {
                onAnimeItemClick(it)
            }
        }
    }
}

@Composable
fun AnimeItem(anime: Anime, onItemClick: (Anime) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
            .clickable {
                onItemClick(anime)
            },
        backgroundColor = Color.White,
        border = BorderStroke(1.dp, PrimaryLight)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            GlideImage(
                imageModel = anime.images?.jpg?.imageUrl,
                modifier = Modifier
                    .width(50.dp)
                    .height(70.dp),
                shimmerParams = ShimmerParams(
                    baseColor = Color.White,
                    highlightColor = HintTextColor,
                    durationMillis = 350,
                    dropOff = 0.65f,
                    tilt = 20f
                ),
                failure = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_error_24),
                        contentDescription = "error"
                    )
                })
            Spacer(modifier = Modifier.width(4.dp))
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = anime.title ?: "Unknown Anime Title",
                    style = animeTitleTextStyle,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${anime.type ?: "Unknown Type"} (${anime.episodes ?: "?"} eps)",
                    style = animeStatTextStyle
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${anime.season ?: "Unknown Season"} ${anime.year ?: "Unknown Year"}",
                    style = animeStatTextStyle
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Rank ${anime.rank ?: "Unknown Rank"}",
                    style = animeStatTextStyle
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(end = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "star",
                    tint = Color.Yellow
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "${anime.score ?: "--"}",
                    style = baseTextStyle
                )
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        backgroundColor = Color.White,
        border = BorderStroke(1.dp, PrimaryLight)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(70.dp)
                    .background(color = Primary)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "${"Boruto"}: Naruto Next Generation jdfhdskj fasf af djsfksjd sdjk ",
                    style = animeTitleTextStyle,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "TV (64 eps)",
                    style = animeStatTextStyle
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Season and Year",
                    style = animeStatTextStyle
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Rank 20",
                    style = animeStatTextStyle
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(end = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "star",
                    tint = Color.Yellow
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "8.23",
                    style = baseTextStyle
                )
            }
        }
    }
}

//GlideImage( // CoilImage, FrescoImage
//imageModel = anime.images?.jpg?.imageUrl,
//modifier = Modifier
//.width(50.dp)
//.height(70.dp),
//// shows an indicator while loading an image.
//shimmerParams = ShimmerParams(
//baseColor = MaterialTheme.colors.background,
//highlightColor = HintTextColor,
//durationMillis = 350,
//dropOff = 0.65f,
//tilt = 20f
//),
//// shows an error text if fail to load an image.
//failure = {
//    Text(text = "image request failed.")
//})