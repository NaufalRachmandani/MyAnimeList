package com.naufal.core.domain

import com.naufal.core.common.Resource
import com.naufal.core.data.source.local.model.anime.AnimeEntity
import com.naufal.core.domain.model.anime.Anime
import com.naufal.core.domain.model.anime_characters.CharacterData
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
    suspend fun getAnimeTop(): Flow<Resource<List<Anime>>>
    suspend fun getAnime(id: String): Flow<Resource<Anime>>
    suspend fun getAnimeCharacters(id: String): Flow<Resource<List<CharacterData>>>
    suspend fun getAnimeSearch(q: String, type: String): Flow<Resource<List<Anime>>>
    suspend fun getAnimeFavorite(): Flow<List<AnimeEntity>>
    suspend fun insertAnime(animeEntity: AnimeEntity)
    suspend fun deleteAnime(animeEntity: AnimeEntity)
}