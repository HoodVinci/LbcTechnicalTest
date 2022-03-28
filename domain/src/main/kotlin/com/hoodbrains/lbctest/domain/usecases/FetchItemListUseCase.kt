package com.hoodbrains.lbctest.domain.usecases

import com.hoodbrains.lbctest.domain.model.Item
import com.hoodbrains.lbctest.domain.repositories.LocalItemListRepository
import com.hoodbrains.lbctest.domain.repositories.RemoteItemListRepository

class FetchItemListUseCase(
    private val remoteItemListRepository: RemoteItemListRepository,
    private val localItemListRepository: LocalItemListRepository
) {

    suspend fun run() =
        runCatching { remoteItemListRepository.fetchList() }
            .onSuccess { saveLocally(it) }
            .recoverCatching { localItemListRepository.fetchList() }

    private suspend fun saveLocally(list: List<Item>) = runCatching {
        localItemListRepository.storeList(list)
    }.onFailure { println("FetchItemListUseCase : $it") }

}