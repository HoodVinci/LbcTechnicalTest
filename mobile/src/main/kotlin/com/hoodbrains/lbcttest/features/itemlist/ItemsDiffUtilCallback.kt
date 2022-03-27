package com.hoodbrains.lbcttest.features.itemlist

import androidx.recyclerview.widget.DiffUtil
import com.hoodbrains.lbctest.presentation.features.itemlist.PresentationItem

internal class ItemsDiffUtilCallback(
    private val newItems: List<PresentationItem>,
    private val oldItems: List<PresentationItem>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition].id == newItems[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition] == newItems[newItemPosition]
}