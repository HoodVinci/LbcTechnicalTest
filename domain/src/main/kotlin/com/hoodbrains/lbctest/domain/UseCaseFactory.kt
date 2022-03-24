package com.hoodbrains.lbctest.domain

import com.hoodbrains.lbctest.domain.usecases.FetchItemListUseCase

class UseCaseFactory(private val repositoryFactory: RepositoryFactory) {

    fun createFetchItemListUseCase() =
        FetchItemListUseCase(
            repositoryFactory.createRemoteItemListRepository(),
            repositoryFactory.createLocalItemListRepository()
        )
}