package com.naufal.core.domain.model.anime_list

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Images(
    val jpg: Jpg? = Jpg()
): Parcelable
