package com.naufal.myanimelist.presentation.anime_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.naufal.core.domain.model.anime_list.Anime
import com.naufal.core.domain.model.anime_list.Genre
import com.naufal.myanimelist.R
import com.naufal.myanimelist.ui.theme.*
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun AnimeDetailScreen(navController: NavController, anime: Anime = Anime()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = anime.title ?: "Unknown Anime Title",
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

        })
}

@Composable
fun InitiateUI(anime: Anime = Anime(), isPreview: Boolean = false) {
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
                text = if (anime.title == "" || anime.title == null) "Unknown Anime Title" else anime.title
                    ?: "",
                style = animeTitleTextStyle
            )
            Spacer(modifier = Modifier.height(2.dp))
            TopSection(
                anime.images?.jpg?.largeImageUrl ?: "",
                "${if (anime.score == null || anime.score == 0.0) "--" else anime.score ?: ""}",
                "${anime.rank ?: "--"}",
                "${anime.popularity ?: "--"}",
                "${anime.type ?: "Unknown Type"} (${anime.episodes ?: "?"} eps)",
                "${anime.season ?: "Unknown Season"} ${anime.year ?: "Unknown Year"}",
                anime.status ?: "--",
                isPreview = isPreview
            )
            Spacer(modifier = Modifier.height(8.dp))
            DescSection(
                source = anime.source,
                rating = anime.rating,
                listGenre = anime.genres,
                synopsis = anime.synopsis
            )
            Spacer(modifier = Modifier.height(16.dp))
            //characters section
        }
    }
}

@Composable
fun TopSection(
    imageUrl: String,
    score: String,
    rank: String,
    popularity: String,
    typeEps: String,
    seasonYear: String,
    status: String,
    isPreview: Boolean = false
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (isPreview) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(140.dp)
                    .background(Primary)
            )
        } else {
            GlideImage(
                imageModel = imageUrl,
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
        }
        Spacer(modifier = Modifier.width(4.dp))
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Primary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = "SCORE",
                    style = baseTextStyle,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = score,
                style = baseTextStyle,
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = typeEps,
                style = baseTextStyle
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Primary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = "RANK",
                    style = baseTextStyle,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = rank,
                style = baseTextStyle,
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = seasonYear,
                style = baseTextStyle,
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Primary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = "POPULARITY",
                    style = baseTextStyle,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = popularity,
                style = baseTextStyle,
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = status,
                style = baseTextStyle,
            )
        }
    }
}

@Composable
fun DescSection(source: String?, rating: String?, listGenre: List<Genre>?, synopsis: String?) {
    var genres = ""
    val genresSize: Int = listGenre?.size ?: 0
    if (genresSize == 0) {
        genres = "No genres found"
    } else {
        for (i in 0..genresSize) {
            if (i == 0) {
                genres = listGenre?.get(i)?.name ?: ""
            } else {
                genres += ", ${listGenre?.get(i)?.name}"
            }
        }
    }
    Text(
        text = "Source: ${source ?: "--"}",
        style = baseTextStyle
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = "Rating: ${rating ?: "--"}",
        style = baseTextStyle
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = "Genre: $genres",
        style = baseTextStyle
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "Synopsis",
        style = SynopsisTitleTextStyle
    )
    Spacer(modifier = Modifier.height(2.dp))
    Text(
        text = synopsis ?: "no synopsis information added",
        style = SynopsisTextStyle,
    )
}

@Composable
fun CharactersSection() {

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
                InitiateUI(anime = Anime(), isPreview = true)
            })
    }
}