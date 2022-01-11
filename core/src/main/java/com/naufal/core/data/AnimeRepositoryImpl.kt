package com.naufal.core.data

import com.naufal.core.common.Resource
import com.naufal.core.data.source.remote.MyAnimeListApi
import com.naufal.core.data.source.remote.model.anime_characters.toCharacterData
import com.naufal.core.data.source.remote.model.anime_list.toAnime
import com.naufal.core.domain.AnimeRepository
import com.naufal.core.domain.model.anime_characters.CharacterData
import com.naufal.core.domain.model.anime_list.Anime
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(private val myAnimeListApi: MyAnimeListApi) :
    AnimeRepository {

    override suspend fun getAnimeTop(): Flow<Resource<List<Anime>>> = flow {
        try {
            emit(Resource.Loading())

            val mutableAnimeList = mutableListOf<Anime>()
            val response = myAnimeListApi.getAnimeTop(1)
            mutableAnimeList.addAll(response.data?.map { it.toAnime() } ?: mutableListOf())
            emit(Resource.Success(data = mutableAnimeList.toList()))

            var page = 1
            var hasNextPage = response.paginationDto?.hasNextPage ?: false
            while (hasNextPage && page < 10) {
                kotlinx.coroutines.delay(3000)
                page++
                val temp = myAnimeListApi.getAnimeTop(page)
                mutableAnimeList.addAll(temp.data?.map { it.toAnime() } ?: mutableListOf())
                hasNextPage = temp.paginationDto?.hasNextPage ?: false
                emit(Resource.Success(data = mutableAnimeList.toList()))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet connection"))
        }
    }

    override suspend fun getAnimeCharacters(id: String): Flow<Resource<List<CharacterData>>> =
        flow {
            try {
                emit(Resource.Loading())
                val characterDataList: List<CharacterData> =
                    myAnimeListApi.getAnimeCharacters(id).data?.map { it.toCharacterData() }
                        ?: mutableListOf()
                emit(Resource.Success(data = characterDataList))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
            } catch (e: IOException) {
                emit(Resource.Error("Check your internet connection"))
            }
        }

    override suspend fun getAnimeSearch(q: String, type: String): Flow<Resource<List<Anime>>> =
        flow {
            try {
                emit(Resource.Loading())
                val animeList: List<Anime> =
                    myAnimeListApi.getAnimeSearch(q, type).data?.map { it.toAnime() }
                        ?: mutableListOf()
                emit(Resource.Success(data = animeList))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
            } catch (e: IOException) {
                emit(Resource.Error("Check your internet connection"))
            }
        }
}