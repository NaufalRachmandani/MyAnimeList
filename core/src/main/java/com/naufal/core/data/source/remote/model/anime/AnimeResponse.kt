package com.naufal.core.data.source.remote.model.anime

import com.google.gson.annotations.SerializedName
import com.naufal.core.data.source.remote.model.anime_list.AnimeDto

data class AnimeResponse(
    @SerializedName("data")
    val data: AnimeDto? = AnimeDto()
)