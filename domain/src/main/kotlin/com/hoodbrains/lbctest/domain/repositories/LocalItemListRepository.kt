package com.hoodbrains.lbctest.domain.repositories

import com.hoodbrains.lbctest.domain.model.Item

interface LocalItemListRepository {
    suspend fun fetchList(): List<Item>

    suspend fun storeList(list: List<Item>)
}