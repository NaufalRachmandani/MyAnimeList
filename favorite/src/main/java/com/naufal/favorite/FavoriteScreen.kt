package com.naufal.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.naufal.myanimelist.ui.theme.Primary
import com.naufal.myanimelist.ui.theme.toolbarTextStyle

@Composable
fun FavoriteScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Favorite Anime",
                        color = Color.White,
                        style = toolbarTextStyle,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                backgroundColor = Primary,
                contentColor = Color.White,
                elevation = 12.dp,
            )
        }, content = {
            Box(modifier = Modifier.fillMaxSize().background(Color.White))
        })
}