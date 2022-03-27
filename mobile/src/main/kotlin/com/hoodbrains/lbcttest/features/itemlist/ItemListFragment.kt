package com.hoodbrains.lbcttest.features.itemlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hoodbrains.lbctest.R
import com.hoodbrains.lbctest.databinding.FragmentItemListBinding
import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListViewState
import com.hoodbrains.lbcttest.AndroidItemListViewModel


class ItemListFragment(
    viewModelFactory: ViewModelProvider.Factory
) : Fragment(R.layout.fragment_item_list) {

    private val adapter = ItemAdapter()

    private val viewModel: AndroidItemListViewModel by viewModels { viewModelFactory }

    private var binding: FragmentItemListBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        super.onCreateView(inflater, container, savedInstanceState)?.also { binding = FragmentItemListBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recycler?.let {
            it.layoutManager = GridLayoutManager(requireContext(), resources.getInteger(R.integer.item_list_column_number))
            it.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onResume() {
        super.onResume()
        viewModel.start().observe(viewLifecycleOwner) { binding?.render(it) }
    }

    private fun FragmentItemListBinding.render(state: ItemListViewState) = when (state) {
        is ItemListViewState.Data -> renderData(state)
        is ItemListViewState.Empty -> renderEmpty(state)
        ItemListViewState.Error -> renderError()
        ItemListViewState.Loading -> renderLoading()
    }


    private fun FragmentItemListBinding.renderLoading() {
        loader.visibility = View.VISIBLE
        text.visibility = View.INVISIBLE
        recycler.visibility = View.INVISIBLE
    }

    private fun FragmentItemListBinding.renderData(state: ItemListViewState.Data) {
        loader.visibility = View.INVISIBLE
        text.visibility = View.INVISIBLE
        recycler.visibility = View.VISIBLE
        adapter.updateItems(state.list)
    }

    private fun FragmentItemListBinding.renderEmpty(state: ItemListViewState.Empty) {
        loader.visibility = View.INVISIBLE
        text.visibility = View.VISIBLE
        recycler.visibility = View.INVISIBLE
        text.text = state.message
    }

    private fun FragmentItemListBinding.renderError() {
        loader.visibility = View.INVISIBLE
        text.visibility = View.VISIBLE
        recycler.visibility = View.INVISIBLE
        text.text = "error"
    }
}