package com.hoodbrains.lbctest.repositories.internal

import com.google.common.truth.Truth.assertThat
import com.hoodbrains.lbcapi.LbcItem
import com.hoodbrains.lbctest.domain.model.Item
import org.junit.Test

class ItemMapperKtTest{
    @Test
    fun `LbcItem mapToItem check mapping`() {
        assertThat(createDefaultLbcItem().mapToItem()).isEqualTo(createDefaultItem())
    }

    private fun createDefaultItem() =
        Item(id = 0, title = "title", imageUrl = "image")

    private fun createDefaultLbcItem() =
        LbcItem(
            albumId = 0,
            id = 0,
            title = "title",
            url = "url",
            thumbnailUrl = "image"
        )

}