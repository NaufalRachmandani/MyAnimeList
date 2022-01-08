package com.naufal.core.domain

import com.naufal.core.common.Resource
import com.naufal.core.domain.model.Anime
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
    suspend fun getAnimeTop(): Flow<Resource<List<Anime>>>
    suspend fun getAnimeSearch(q: String, type: String): Flow<Resource<List<Anime>>>
}