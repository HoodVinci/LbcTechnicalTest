package com.hoodbrains.lbctest.repositories.internal

import com.google.common.truth.Truth.assertThat
import com.hoodbrains.lbctest.domain.model.Item
import com.hoodbrains.lbctest.local.api.LocalItem
import com.hoodbrains.lbctest.local.api.LocalItemStore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class LocalItemRepositoryImplTest {

    private val localItemStore: LocalItemStore = mock()

    private val repository = LocalItemRepositoryImpl(localItemStore)


    @Test(expected = Exception::class)
    fun `fetchList , on store error, re throw`() = runTest {
        whenever(localItemStore.getAll()).thenThrow(NullPointerException())
        repository.fetchList()
    }

    @Test
    fun `fetchList , nominal case`() = runTest {
        whenever(localItemStore.getAll()).thenReturn(listOf(createLocalItem()))
        assertThat(repository.fetchList()).containsExactly(createItem()).inOrder()
    }

    @Test(expected = Exception::class)
    fun `save List , on error re throw`() = runTest{
        whenever(localItemStore.save(any())).thenThrow(NullPointerException())
        repository.storeList(listOf())
    }

    @Test
    fun `save List , nominal case`() = runTest{
        repository.storeList(listOf(createItem()))

        verify(localItemStore).clearAll()
        verify(localItemStore).save(listOf(createLocalItem()))

    }

    private fun createItem() = Item(1, "title", "url")

    private fun createLocalItem() = LocalItem(1, "title", "url")
}