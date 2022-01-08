package com.naufal.myanimelist.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.naufal.myanimelist.R
import com.naufal.myanimelist.presentation.home.components.SearchSection
import com.naufal.myanimelist.ui.theme.MyAnimeListTheme
import com.naufal.myanimelist.ui.theme.Shapes

@Composable
fun SearchBar(modifier: Modifier = Modifier, placeholder: String = "Type anime name here...") {
    var searchText by remember {
        mutableStateOf("")
    }
    TextField(
        modifier = modifier,
        shape = Shapes.medium,
        value = searchText,
        onValueChange = {
            searchText = it
        },
        textStyle = MaterialTheme.typography.body2,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                tint = colorResource(id = R.color.primary),
                contentDescription = "Icon Search",
                modifier = Modifier.size(24.dp)
            )
        },
        label = null,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            cursorColor = colorResource(id = R.color.primary),
            focusedIndicatorColor = Color.Transparent, //hide the indicator
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Box(modifier = Modifier.height(24.dp), contentAlignment = Alignment.CenterStart) {
                Text(
                    text = placeholder,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAnimeListTheme {
        SearchBar(modifier = Modifier.fillMaxWidth())
    }
}