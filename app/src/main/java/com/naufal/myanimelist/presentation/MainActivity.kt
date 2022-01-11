package com.naufal.myanimelist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.naufal.myanimelist.presentation.anime_detail.AnimeDetailScreen
import com.naufal.myanimelist.presentation.home.HomeScreen
import com.naufal.myanimelist.presentation.home.HomeViewModel
import com.naufal.myanimelist.ui.theme.MyAnimeListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            viewModel.getAnimeTop()
            setKeepVisibleCondition {
                viewModel.state.value.isLoading
            }
        }

        setContent {
            MyAnimeListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.AnimeListScreen.route
                    ) {
                        composable(route = Screen.AnimeListScreen.route) {
                            HomeScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AnimeDetailScreen.route + "/{malId}/{title}",
                            arguments = listOf(
                                navArgument("malId") {
                                    type = NavType.IntType
                                },
                                navArgument("title") {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            val malId = it.arguments?.getInt("malId") ?: 0
                            val title = it.arguments?.getString("title") ?: ""
                            AnimeDetailScreen(navController = navController, malId = malId, title = title)
                        }
                    }
                }
            }
        }
    }
}