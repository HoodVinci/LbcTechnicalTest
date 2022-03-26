package com.hoodbrains.lbctest.presentation.features.itemlist.internal

import com.google.common.truth.Truth.assertThat
import com.hoodbrains.lbctest.domain.usecases.FetchItemListUseCase
import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListViewState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class ItemListViewModelImplTest {

    private val fetchItemListUseCase: FetchItemListUseCase = mock {
        onBlocking { run() } doReturn Result.success(listOf())
    }
    private val mapper: ItemListViewModelMapper = mock {
        on { map(any()) } doReturn ItemListViewState.Data(listOf())
    }

    private val viewModel = ItemListViewModelImpl(fetchItemListUseCase, mapper)


    @Test
    fun `start, when use case error`() = runTest {
        whenever(fetchItemListUseCase.run()).thenReturn(Result.failure(NullPointerException()))

        val states = viewModel.start().toList()

        assertThat(states).containsExactly(ItemListViewState.Loading, ItemListViewState.Error).inOrder()
    }

    @Test
    fun `start, when mapping error`() = runTest {
        whenever(mapper.map(any())).thenThrow(NullPointerException())

        val states = viewModel.start().toList()

        assertThat(states).containsExactly(ItemListViewState.Loading, ItemListViewState.Error).inOrder()
    }

    @Test
    fun `start, nominal with data`() = runTest {
        val states = viewModel.start().toList()

        assertThat(states).containsExactly(ItemListViewState.Loading, ItemListViewState.Data(listOf())).inOrder()
    }

    @Test
    fun `start, nominal with empty`() = runTest {
        whenever(mapper.map(any())).thenReturn(ItemListViewState.Empty(""))

        val states = viewModel.start().toList()

        assertThat(states).containsExactly(ItemListViewState.Loading, ItemListViewState.Empty("")).inOrder()
    }
}