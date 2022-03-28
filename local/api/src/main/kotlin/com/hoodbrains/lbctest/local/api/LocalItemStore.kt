package com.hoodbrains.lbctest.local.api

interface LocalItemStore {

    suspend fun clearAll()

    suspend fun save(list: List<LocalItem>)

   suspend fun getAll(): List<LocalItem>
}