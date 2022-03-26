package com.hoodbrains.lbctest.presentation.features.itemlist

import kotlinx.coroutines.flow.Flow


sealed class ItemListViewState {
    object Loading : ItemListViewState()
    data class Data(val list: List<PresentationItem>) : ItemListViewState()
    data class Empty(val message: String) : ItemListViewState()
    object Error : ItemListViewState()

}

interface ItemListViewModel {
    fun start(): Flow<ItemListViewState>
}