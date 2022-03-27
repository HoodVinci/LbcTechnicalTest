package com.hoodbrains.lbctest.repositories.internal

import com.hoodbrains.lbcapi.LbcItem
import com.hoodbrains.lbctest.domain.model.Item
import com.hoodbrains.lbctest.local.api.LocalItem


internal fun LbcItem.mapToItem(): Item = Item(id, title, thumbnailUrl)

internal fun LocalItem.mapToItem(): Item = Item(id, title, imageUrl)
internal fun Item.mapToLocalItem(): LocalItem = LocalItem(id, title, imageUrl)