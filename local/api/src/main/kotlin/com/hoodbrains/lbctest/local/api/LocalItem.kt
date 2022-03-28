package com.hoodbrains.lbctest.local.api

import kotlinx.serialization.Serializable

@Serializable
data class LocalItem(
    val id: Int,
    val title: String,
    val imageUrl: String
)