package com.hoodbrains.lbctest.local.api

interface LocalItemStore {

    fun clearAll()

    fun save(list: List<LocalItem>)

    fun getAll(): List<LocalItem>
}