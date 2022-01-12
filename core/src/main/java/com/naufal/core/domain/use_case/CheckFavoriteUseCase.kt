package com.naufal.core.domain.use_case

import com.naufal.core.domain.AnimeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CheckFavoriteUseCase @Inject constructor(private val animeRepository: AnimeRepository) {
    suspend operator fun invoke(id: Int): Flow<Boolean> = animeRepository.exist(id)
}