package com.hoodbrains.lbcttest

import android.content.Context
import com.hoodbrains.lbctest.presentation.ResourcesFactory
import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListResources
import com.hoodbrains.lbcttest.features.itemlist.ItemListResourcesImpl

class ResourcesFactoryImpl(private val context: Context) : ResourcesFactory {
    override fun createItemListResources(): ItemListResources = ItemListResourcesImpl(context)
}