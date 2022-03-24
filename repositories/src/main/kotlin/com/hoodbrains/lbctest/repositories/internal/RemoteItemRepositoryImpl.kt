package com.hoodbrains.lbctest.repositories.internal

import com.hoodbrains.lbcapi.LbcApi
import com.hoodbrains.lbctest.domain.model.Item
import com.hoodbrains.lbctest.domain.repositories.RemoteItemListRepository

class RemoteItemRepositoryImpl(private val api: LbcApi) : RemoteItemListRepository {

    override suspend fun fetchList(): List<Item> =
        api.fetchItemList().map { it.mapToItem() }
}