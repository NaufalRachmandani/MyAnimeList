package com.naufal.core.domain

import com.naufal.core.common.Resource
import com.naufal.core.domain.model.anime_characters.CharacterData
import com.naufal.core.domain.model.anime_list.Anime
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
    suspend fun getAnimeTop(): Flow<Resource<List<Anime>>>
    suspend fun getAnimeCharacters(id: String): Flow<Resource<List<CharacterData>>>
    suspend fun getAnimeSearch(q: String, type: String): Flow<Resource<List<Anime>>>
}