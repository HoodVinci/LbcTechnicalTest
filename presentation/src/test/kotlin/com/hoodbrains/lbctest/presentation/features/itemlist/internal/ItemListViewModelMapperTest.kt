package com.hoodbrains.lbctest.presentation.features.itemlist.internal

import TestBuilders
import com.google.common.truth.Truth.assertThat
import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListResources
import com.hoodbrains.lbctest.presentation.features.itemlist.ItemListViewState
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class ItemListViewModelMapperTest {

    private val resources: ItemListResources = mock {
        on { messageWhenEmpty } doReturn "Oupsy!"
    }
    private lateinit var mapper: ItemListViewModelMapper


    @Before
    fun setUp() {
        mapper = ItemListViewModelMapper(resources)
    }

    @Test
    fun `map, when empty list, return Empty with message`() {
        val result = mapper.map(listOf())

        assertThat(result).isEqualTo(ItemListViewState.Empty("Oupsy!"))
    }

    @Test
    fun `map, when data, return Data with matching presentationItems`() {
        val result = mapper.map(listOf(TestBuilders.domainItem(title = "hello", imageUrl = "UrL")))

        val expected = ItemListViewState.Data(listOf(TestBuilders.presentation(title = "hello", imageUrl = "UrL")))
        assertThat(result).isEqualTo(expected)
    }

}

