package com.hoodbrains.lbctest.repositories.internal

import com.hoodbrains.lbctest.domain.model.Item
import com.hoodbrains.lbctest.domain.repositories.LocalItemListRepository
import com.hoodbrains.lbctest.local.api.LocalItemStore

internal class LocalItemRepositoryImpl(private val localItemStore: LocalItemStore) : LocalItemListRepository {

    override suspend fun fetchList(): List<Item> =
        localItemStore.getAll().map { it.mapToItem() }

    override suspend fun storeList(list: List<Item>) {
        localItemStore.clearAll()
        localItemStore.save(list.map { it.mapToLocalItem() })
    }

}