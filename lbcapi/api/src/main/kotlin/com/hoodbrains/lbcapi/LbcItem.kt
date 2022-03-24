package com.hoodbrains.lbcapi

import kotlinx.serialization.Serializable

@Serializable
data class LbcItem(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)