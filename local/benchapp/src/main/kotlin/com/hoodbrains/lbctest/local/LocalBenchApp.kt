package com.hoodbrains.lbctest.local

import com.hoodbrains.lbctest.local.api.LocalItem
import com.hoodbrains.lbctest.local.api.LocalItemStore
import com.hoodbrains.lbctest.local.simplefile.createLocalItemStore
import kotlinx.coroutines.runBlocking
import java.io.File
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    runBlocking {
        runCatching { executeTestSuite(createItemList(5000)) }
    }
    exitProcess(0)
}

private suspend fun executeTestSuite(list: List<LocalItem>) {

    val file = File("testFile")
    val store = createLocalItemStore(file.absolutePath)

    store.executeTest("1 clear, 1 write, 1000 reads") {
        clearAll()
        save(list)
        repeat(1000) {
            getAll()
        }
    }

    store.executeTest("1 clear, 100 writes, 100 reads, 100 writes") {
        clearAll()
        repeat(100) { save(list) }
        repeat(100) { getAll() }
        repeat(100) { save(list) }
    }

    file.delete()
}


private fun createItemList(number: Int) = List(number) { LocalItem(0, "title", "url") }

private suspend fun LocalItemStore.executeTest(title: String, test: suspend LocalItemStore.() -> Unit) {
    val start = System.currentTimeMillis()
    runCatching { this.test() }
        .onFailure { println("$title failed") }
        .onSuccess { println("$title success in ${System.currentTimeMillis() - start} ms") }
}