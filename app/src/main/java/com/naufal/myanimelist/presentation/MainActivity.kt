package com.naufal.myanimelist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.naufal.myanimelist.presentation.home.HomeViewModel
import com.naufal.myanimelist.ui.theme.MyAnimeListTheme
import com.ramcosta.composedestinations.DestinationsNavHost
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
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}