package com.hoodbrains.lbcapi

interface LbcApi {
    suspend fun fetchItemList(): List<LbcItem>
}