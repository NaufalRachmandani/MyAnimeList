package com.naufal.core.domain.model.anime_list

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genre(
    val malId: Int? = 0,
    val name: String? = "",
    val type: String? = "",
    val url: String? = ""
): Parcelable
