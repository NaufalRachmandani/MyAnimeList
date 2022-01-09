package com.naufal.myanimelist.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.naufal.core.domain.model.Anime
import com.naufal.core.domain.model.Images
import com.naufal.core.domain.model.Jpg
import com.naufal.myanimelist.ui.theme.HintTextColor
import com.naufal.myanimelist.ui.theme.TextColor
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun AnimeItem(anime: Anime, onItemClick: (Anime) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .clickable {
                onItemClick(anime)
            }
    ) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(70.dp)
        ) {
            GlideImage( // CoilImage, FrescoImage
                imageModel = anime.images?.jpg?.imageUrl,
                modifier = Modifier
                    .width(50.dp)
                    .height(70.dp),
                // shows an indicator while loading an image.
                shimmerParams = ShimmerParams(
                    baseColor = MaterialTheme.colors.background,
                    highlightColor = HintTextColor,
                    durationMillis = 350,
                    dropOff = 0.65f,
                    tilt = 20f
                ),
                // shows an error text if fail to load an image.
                failure = {
                    Text(text = "image request failed.")
                })
        }

        Spacer(modifier = Modifier.width(4.dp))
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = anime.title ?: "Unknown Anime Title",
                color = TextColor,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    AnimeItem(
        Anime(
            images =
            Images(jpg = Jpg(imageUrl = "https://cdn.myanimelist.net/images/anime/1223/96541.jpg")),
            title = "Judul anime"
        )
    ) {

    }
}