package com.hoodbrains.lbctest.domain.usecases

import com.google.common.truth.Truth.assertThat
import com.hoodbrains.lbctest.domain.repositories.LocalItemListRepository
import com.hoodbrains.lbctest.domain.repositories.RemoteItemListRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoInteractions
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever


@ExperimentalCoroutinesApi
class FetchItemListUseCaseTest {

    private val remoteRepository: RemoteItemListRepository = mock()
    private val localRepository: LocalItemListRepository = mock()

    private lateinit var fetchItemListUseCase: FetchItemListUseCase

    @Before
    fun setUp() {
        fetchItemListUseCase = FetchItemListUseCase(remoteRepository, localRepository)
    }

    @Test
    fun `on remote error try to call local`() = runTest {
        whenever(remoteRepository.fetchList()).thenThrow(NullPointerException())

        fetchItemListUseCase.run()

        verify(localRepository).fetchList()
    }

    @Test
    fun `on remote success only save locally, return success`() = runTest {
        whenever(remoteRepository.fetchList()).thenReturn(listOf())

        val result = fetchItemListUseCase.run()

        verify(localRepository).storeList(listOf())
        verifyNoMoreInteractions(localRepository)
        assertThat(result.isSuccess).isTrue()
    }

    @Test
    fun `on remote success save to local, on save error ,return success`() = runTest {
        whenever(remoteRepository.fetchList()).thenReturn(listOf())
        whenever(localRepository.storeList(any())).thenThrow(NullPointerException())

        val result = fetchItemListUseCase.run()

        assertThat(result.isSuccess).isTrue()

    }

    @Test
    fun `on remote error and local error return error`() = runTest {
        whenever(remoteRepository.fetchList()).thenThrow(NullPointerException())
        whenever(localRepository.fetchList()).thenThrow(NullPointerException())

        val result = fetchItemListUseCase.run()

        assertThat(result.isFailure).isTrue()
    }

    @Test
    fun `on remote error and local success return success`() = runTest {
        whenever(remoteRepository.fetchList()).thenThrow(NullPointerException())
        whenever(localRepository.fetchList()).thenReturn(listOf())

        val result = fetchItemListUseCase.run()

        assertThat(result.isSuccess).isTrue()
    }
}