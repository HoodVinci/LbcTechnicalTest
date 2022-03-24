package com.hoodbrains.lbcapi

import com.hoodbrains.lbcapi.ktor.createApi
import kotlinx.coroutines.runBlocking


fun main(args: Array<String>) {

    val itemsList = runBlocking { createApi().fetchItemList() }

    runCatching {
        assert(itemsList.isNotEmpty()) { "Empty List" }
        checkNoDuplicateIds(itemsList)
        checkNoEmptyField(itemsList, "url") { it.url }
        checkNoEmptyField(itemsList, "thumbnailUrl") { it.thumbnailUrl }
        checkNoEmptyField(itemsList, "title") { it.title }
    }.onFailure { println(it.message) }
        .onSuccess { println("Everything is Ok with api") }
}

fun checkNoEmptyField(itemList: List<LbcItem>, fieldName: String, fieldGetter: (LbcItem) -> String) =
    assert(itemList.none { fieldGetter(it).isEmpty() }) { "at least one item has $fieldName empty" }

fun checkNoDuplicateIds(itemList: List<LbcItem>) {
    val ids = itemList.map { it.id }
    assert(ids.size == ids.distinct().size) { "Duplicate ids in list" }
}

