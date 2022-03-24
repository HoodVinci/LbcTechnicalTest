package com.hoodbrains.lbcapi

import org.junit.Test

class WatchdogKtTest {

    @Test(expected = AssertionError::class)
    fun `checkNoEmptyField with empty field`() {
        checkNoEmptyField(listOf(createLbcItem(fieldFiller = "")), "url") { it.url }
    }

    @Test
    fun `checkNoEmptyField with not empty field`() {
        checkNoEmptyField(listOf(createLbcItem(fieldFiller = "a")), "url") { it.url }
    }

    @Test(expected = AssertionError::class)
    fun `checkNoDuplicateIds with duplicate ids`() {
        checkNoDuplicateIds(listOf(createLbcItem(1),createLbcItem(1)))
    }

    @Test
    fun `checkNoDuplicateIds with no duplicate ids`() {
        checkNoDuplicateIds(listOf(createLbcItem(1),createLbcItem(2)))
    }

    private fun createLbcItem(id: Int = 0, fieldFiller: String = "") = LbcItem(
        albumId = 0,
        id = id,
        title = fieldFiller,
        url = fieldFiller,
        thumbnailUrl = fieldFiller
    )
}