package com.hoodbrains.lbctest.domain.repositories

import com.hoodbrains.lbctest.domain.model.Item

interface RemoteItemListRepository {
    suspend fun fetchList() : List<Item>
}