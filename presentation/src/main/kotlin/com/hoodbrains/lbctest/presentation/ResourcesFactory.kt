package com.hoodbrains.lbctest.presentation

import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListResources

interface ResourcesFactory {

    fun createItemListResources(): ItemListResources
}