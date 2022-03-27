package com.hoodbrains.lbctest.local.simplefile

import com.hoodbrains.lbctest.local.api.LocalItem
import com.hoodbrains.lbctest.local.api.LocalItemStore
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import okio.FileSystem
import okio.Path
import java.util.concurrent.Executors

internal class LocalStoreFileImpl(
    private val filePath: Path,
    private val fileSystem: FileSystem = FileSystem.SYSTEM,
    private val dispatcher: CoroutineDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
) : LocalItemStore {

    private val serializer = ListSerializer(LocalItem.serializer())

    private val json = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
    }

    override suspend fun clearAll() = save(listOf())

    override suspend fun save(list: List<LocalItem>) = withContext(dispatcher) {
        fileSystem.write(filePath) { writeUtf8(json.encodeToString(serializer, list)) }
        Unit
    }

    override suspend fun getAll(): List<LocalItem> = withContext(dispatcher) {
        json.decodeFromString(serializer, fileSystem.read(filePath) { readUtf8() })
    }

}


