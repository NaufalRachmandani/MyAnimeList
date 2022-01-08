package com.naufal.myanimelist.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.naufal.myanimelist.ui.theme.MyAnimeListTheme

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val uiState = viewModel.state
}

@Composable
fun InitiateUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(color = colorResource(id = R.color.gray_light))
    ) {

    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAnimeListTheme {
        InitiateUI()
    }
}
