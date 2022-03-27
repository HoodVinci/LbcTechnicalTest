package com.hoodbrains.lbctest.local.simplefile

import com.hoodbrains.lbctest.local.api.LocalItemStore
import okio.Path.Companion.toPath

class LocalItemStoreFactory {

    fun createLocalItemStore(filePath: String): LocalItemStore = LocalStoreFileImpl(filePath = filePath.toPath())
}