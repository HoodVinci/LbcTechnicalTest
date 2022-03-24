package com.hoodbrains.lbctest.repositories.internal

import com.hoodbrains.lbcapi.LbcItem
import com.hoodbrains.lbctest.domain.model.Item


internal fun LbcItem.mapToItem(): Item = Item(id, title, thumbnailUrl)