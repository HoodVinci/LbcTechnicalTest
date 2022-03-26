package com.hoodbrains.lbctest.repositories

import com.hoodbrains.lbcapi.LbcApi
import com.hoodbrains.lbctest.domain.RepositoryFactory
import com.hoodbrains.lbctest.domain.model.Item
import com.hoodbrains.lbctest.domain.repositories.LocalItemListRepository
import com.hoodbrains.lbctest.domain.repositories.RemoteItemListRepository
import com.hoodbrains.lbctest.repositories.internal.RemoteItemRepositoryImpl

class RepositoriesAssembler(
    private val api: LbcApi
)  : RepositoryFactory{

    override fun createLocalItemListRepository(): LocalItemListRepository =
        object : LocalItemListRepository{
            override suspend fun fetchList(): List<Item> {
                TODO("Not yet implemented")
            }
        }

    override fun createRemoteItemListRepository(): RemoteItemListRepository =
        RemoteItemRepositoryImpl(api)
}