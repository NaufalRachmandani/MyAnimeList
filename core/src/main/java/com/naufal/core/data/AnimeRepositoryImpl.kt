package com.naufal.core.data

import com.naufal.core.common.Resource
import com.naufal.core.data.source.remote.MyAnimeListApi
import com.naufal.core.data.source.remote.model.anime_list.toAnime
import com.naufal.core.domain.AnimeRepository
import com.naufal.core.domain.model.Anime
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
            val animeList: List<Anime> =
                myAnimeListApi.getAnimeTop().data?.map { it.toAnime() } ?: mutableListOf()
            emit(Resource.Success(data = animeList))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet connection"))
        }
    }

    override suspend fun getAnimeSearch(q: String, type: String): Flow<Resource<List<Anime>>> = flow {
        try {
            emit(Resource.Loading())
            val animeList: List<Anime> =
                myAnimeListApi.getAnimeTop().data?.map { it.toAnime() } ?: mutableListOf()
            emit(Resource.Success(data = animeList))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet connection"))
        }
    }
}