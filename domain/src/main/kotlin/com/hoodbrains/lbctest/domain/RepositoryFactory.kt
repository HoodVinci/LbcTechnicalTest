package com.hoodbrains.lbctest.domain

import com.hoodbrains.lbctest.domain.repositories.LocalItemListRepository
import com.hoodbrains.lbctest.domain.repositories.RemoteItemListRepository

interface RepositoryFactory {
    fun createLocalItemListRepository(): LocalItemListRepository

    fun createRemoteItemListRepository(): RemoteItemListRepository
}