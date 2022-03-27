package com.hoodbrains.lbcttest

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.hoodbrains.lbctest.presentation.ViewModelFactory
import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListViewModel
import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListViewState

class AndroidViewModelFactory(
    private val viewModelFactory: ViewModelFactory
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel: ViewModel = when (modelClass) {
            AndroidItemListViewModel::class.java -> AndroidItemListViewModel(viewModelFactory.createItemListViewModel())
            else -> throw IllegalArgumentException("this view model is not supported")
        }
        return viewModel as T
    }
}


class AndroidItemListViewModel(private val itemListViewModel: ItemListViewModel) : ViewModel() {
    fun start(): LiveData<ItemListViewState> = itemListViewModel.start().asLiveData()
}