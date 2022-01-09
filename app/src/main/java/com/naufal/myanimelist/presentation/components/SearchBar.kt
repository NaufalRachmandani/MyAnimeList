package com.naufal.myanimelist.presentation.components

import androidx.compose.foundation.background
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
import com.naufal.myanimelist.presentation.search.components.SearchSection
import com.naufal.myanimelist.ui.theme.MyAnimeListTheme
import com.naufal.myanimelist.ui.theme.Primary
import com.naufal.myanimelist.ui.theme.PrimaryLight
import com.naufal.myanimelist.ui.theme.Shapes

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    placeholder: String = "Type anime name here...",
    onValueChanged: (String) -> Unit
) {
    var searchText by remember {
        mutableStateOf("")
    }
    TextField(
        modifier = modifier.height(48.dp),
        shape = Shapes.medium,
        value = searchText,
        onValueChange = {
            searchText = it
            onValueChanged(it)
        },
        textStyle = MaterialTheme.typography.subtitle1,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                tint = colorResource(id = R.color.primary),
                contentDescription = "Icon Search",
                modifier = Modifier.size(18.dp)
            )
        },
        label = null,
//        colors = TextFieldDefaults.textFieldColors(
//            backgroundColor = Color.White,
//            cursorColor = colorResource(id = R.color.primary),
//            focusedIndicatorColor = Color.Transparent, //hide the indicator
//            unfocusedIndicatorColor = Color.Transparent,
//        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            unfocusedBorderColor = PrimaryLight,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            backgroundColor = Color.White,
        ),
        placeholder = {
            Box(modifier = Modifier.height(18.dp), contentAlignment = Alignment.CenterStart) {
                Text(
                    text = placeholder,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1,
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAnimeListTheme {
        SearchBar(modifier = Modifier.fillMaxWidth()) {

        }
    }
}