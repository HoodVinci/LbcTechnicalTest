package com.hoodbrains.lbcttest.features.itemlist

import android.content.Context
import com.hoodbrains.lbctest.R
import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListResources

class ItemListResourcesImpl(context: Context) : ItemListResources {
    override val messageWhenEmpty: String = context.getString(R.string.empty_list_message)

}