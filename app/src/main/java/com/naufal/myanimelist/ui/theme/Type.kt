package com.naufal.myanimelist.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.naufal.myanimelist.R

val rubik = FontFamily(
    Font(R.font.rubik_regular),
    Font(R.font.rubik_medium, FontWeight.Medium),
    Font(R.font.rubik_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
    ),
    h2 = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    )
)

val animeTitleTextStyle = TextStyle(
    color = Primary,
    fontSize = 14.sp,
    fontWeight = FontWeight.Bold,
    fontStyle = FontStyle.Normal,
    fontFamily = rubik
)

val animeStatTextStyle = TextStyle(
    color = SofterTextColor,
    fontSize = 10.sp,
    fontWeight = FontWeight.Normal,
    fontStyle = FontStyle.Normal,
    fontFamily = rubik
)

val baseTextStyle = TextStyle(
    color = TextColor,
    fontSize = 12.sp,
    fontWeight = FontWeight.Normal,
    fontStyle = FontStyle.Normal,
    fontFamily = rubik
)

val toolbarTextStyle = TextStyle(
    color = TextColor,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold,
    fontStyle = FontStyle.Normal,
    fontFamily = rubik
)