package com.hoodbrains.lbcttest.features.itemlist

import androidx.recyclerview.widget.RecyclerView
import com.hoodbrains.lbctest.databinding.ItemBinding
import com.hoodbrains.lbctest.presentation.features.itemlist.PresentationItem
import com.hoodbrains.lbcttest.imageloading.clearLoadings
import com.hoodbrains.lbcttest.imageloading.load

class ItemViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PresentationItem) {
        binding.title.text = item.title
        binding.image.load(item.imageUrl)
    }

    fun prepareForRecycling() {
        binding.image.clearLoadings()
    }

}