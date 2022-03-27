package com.hoodbrains.lbctest.presentation.features.itemlist.internal

import com.hoodbrains.lbctest.domain.model.Item
import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListResources
import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListViewState
import com.hoodbrains.lbctest.presentation.features.itemlist.PresentationItem

internal class ItemListViewModelMapper(private val itemListResources: ItemListResources) {

    fun map(list: List<Item>): ItemListViewState =
        if (list.isEmpty()) {
            ItemListViewState.Empty(itemListResources.messageWhenEmpty)
        } else {
            ItemListViewState.Data(list.map { PresentationItem(it.id, it.title, it.imageUrl) })
        }
}