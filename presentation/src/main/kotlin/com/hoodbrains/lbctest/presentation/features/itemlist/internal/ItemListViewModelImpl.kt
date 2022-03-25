package com.hoodbrains.lbctest.presentation.features.itemlist.internal

import com.hoodbrains.lbctest.domain.usecases.FetchItemListUseCase
import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListViewModel
import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class ItemListViewModelImpl(
    private val fetchItemListUseCase: FetchItemListUseCase,
    private val mapper: ItemListViewModelMapper
) : ItemListViewModel {

    override fun start(): Flow<ItemListViewState> = flow {
        emit(ItemListViewState.Loading)
        fetchItemListUseCase.run()
            .mapCatching(mapper::map)
            .onFailure { emit(ItemListViewState.Error) }
            .onSuccess { emit(it) }
    }
}