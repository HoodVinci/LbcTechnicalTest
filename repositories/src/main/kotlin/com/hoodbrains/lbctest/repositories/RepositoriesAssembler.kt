package com.hoodbrains.lbctest.repositories

import com.hoodbrains.lbcapi.LbcApi
import com.hoodbrains.lbctest.domain.RepositoryFactory
import com.hoodbrains.lbctest.domain.model.Item
import com.hoodbrains.lbctest.domain.repositories.LocalItemListRepository
import com.hoodbrains.lbctest.domain.repositories.RemoteItemListRepository
import com.hoodbrains.lbctest.local.api.LocalItemStore
import com.hoodbrains.lbctest.repositories.internal.LocalItemRepositoryImpl
import com.hoodbrains.lbctest.repositories.internal.RemoteItemRepositoryImpl

class RepositoriesAssembler(
    private val api: LbcApi,
    private val local: LocalItemStore
)  : RepositoryFactory{

    override fun createLocalItemListRepository(): LocalItemListRepository =
        LocalItemRepositoryImpl(local)

    override fun createRemoteItemListRepository(): RemoteItemListRepository =
        RemoteItemRepositoryImpl(api)
}