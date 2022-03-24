package com.hoodbrains.lbctest.domain.usecases

import com.hoodbrains.lbctest.domain.repositories.LocalItemListRepository
import com.hoodbrains.lbctest.domain.repositories.RemoteItemListRepository

class FetchItemListUseCase(
    private val remoteItemListRepository: RemoteItemListRepository,
    private val localItemListRepository: LocalItemListRepository
) {

    suspend fun run() =
        runCatching { remoteItemListRepository.fetchList() }
            .recoverCatching { localItemListRepository.fetchList() }

}