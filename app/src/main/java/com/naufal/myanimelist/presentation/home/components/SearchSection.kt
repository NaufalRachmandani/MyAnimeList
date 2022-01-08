package com.naufal.myanimelist.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.naufal.myanimelist.R
import com.naufal.myanimelist.ui.theme.MyAnimeListTheme
import com.naufal.myanimelist.ui.theme.Shapes

@Composable
fun SearchSection(
    modifier: Modifier = Modifier,
) {
//    Column(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(horizontal = 16.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Center
//        ) {
//            SearchBar(modifier = Modifier.weight(1f))
//            Spacer(modifier = Modifier.width(16.dp))
//            FilterButton(modifier = Modifier.size(24.dp), onFilterClick = {
//                onFilterClick()
//            })
//        }
////        AnimatedVisibility(
////            visible = state.isOrderSectionVisible,
////            enter = fadeIn() + slideInVertically(),
////            exit = fadeOut() + slideOutVertically()
////        ) {
////            OrderSection(
////                modifier = Modifier
////                    .fillMaxWidth()
////                    .padding(vertical = 16.dp),
////                userOrder = state.userOrder,
////                onOrderChanges = {
////                    onOrderChanges(it)
////                }
////            )
////        }
//    }
}

@Composable
fun FilterButton(modifier: Modifier = Modifier, onFilterClick: () -> Unit) {
    Box(modifier = modifier
        .clickable {
            onFilterClick()
        }) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_filter_list_24),
            contentDescription = "filter"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAnimeListTheme {
        SearchSection(modifier = Modifier.fillMaxWidth())
    }
}