package com.hoodbrains.lbcttest.features.itemlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.hoodbrains.lbctest.R
import com.hoodbrains.lbctest.databinding.FragmentItemListBinding
import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListViewState
import com.hoodbrains.lbcttest.AndroidItemListViewModel


class ItemListFragment(
    viewModelFactory: ViewModelProvider.Factory
) : Fragment(R.layout.fragment_item_list) {

    private val viewModel: AndroidItemListViewModel by viewModels { viewModelFactory }

    private var binding: FragmentItemListBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        super.onCreateView(inflater, container, savedInstanceState)?.also { binding = FragmentItemListBinding.bind(it) }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onResume() {
        super.onResume()
        viewModel.start().observe(viewLifecycleOwner) { render(it) }
    }

    private fun render(state: ItemListViewState) {
        binding?.text?.text =
            when (state) {
                is ItemListViewState.Data -> "${state.list.size} items "
                is ItemListViewState.Empty -> state.message
                ItemListViewState.Error -> "error"
                ItemListViewState.Loading -> "loading"
            }
    }

}