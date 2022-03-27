package com.hoodbrains.lbcttest.features.itemlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hoodbrains.lbctest.databinding.ItemBinding
import com.hoodbrains.lbctest.presentation.features.itemlist.PresentationItem

class ItemAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    private var items: List<PresentationItem> = listOf()

    init {
        setHasStableIds(true)
    }

    fun updateItems(newItems: List<PresentationItem>) {
        val itemsDiffUtilCallback = ItemsDiffUtilCallback(newItems = newItems, oldItems = items)
        items = newItems
        DiffUtil.calculateDiff(itemsDiffUtilCallback).dispatchUpdatesTo(this)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
        holder.bind(items[position])


    override fun onViewRecycled(holder: ItemViewHolder) {
        holder.prepareForRecycling()
        super.onViewRecycled(holder)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemId(position: Int): Long = items[position].id.toLong()
}