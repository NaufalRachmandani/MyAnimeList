package com.naufal.core.domain.use_case

import com.naufal.core.common.Resource
import com.naufal.core.domain.AnimeRepository
import com.naufal.core.domain.model.Anime
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAnimeTopUseCase @Inject constructor(private val animeRepository: AnimeRepository) {
    suspend operator fun invoke(): Flow<Resource<List<Anime>>> = animeRepository.getAnimeTop()
}