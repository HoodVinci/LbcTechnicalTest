package com.hoodbrains.lbctest.presentation

import com.hoodbrains.lbctest.domain.UseCaseFactory
import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListResources
import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListViewModel
import com.hoodbrains.lbctest.presentation.features.itemlist.internal.ItemListViewModelImpl
import com.hoodbrains.lbctest.presentation.features.itemlist.internal.ItemListViewModelMapper

class ViewModelFactory(
    private val useCaseFactory: UseCaseFactory
) {

    fun createItemListViewModel(itemListResources: ItemListResources): ItemListViewModel =
        ItemListViewModelImpl(
            fetchItemListUseCase = useCaseFactory.createFetchItemListUseCase(),
            mapper = ItemListViewModelMapper(itemListResources)
        )
}