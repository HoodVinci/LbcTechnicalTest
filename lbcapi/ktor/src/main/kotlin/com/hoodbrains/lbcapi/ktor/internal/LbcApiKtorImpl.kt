package com.hoodbrains.lbcapi.ktor.internal

import com.hoodbrains.lbcapi.LbcApi
import com.hoodbrains.lbcapi.LbcItem
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.get
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule

internal class LbcApiKtorImpl : LbcApi {

    private val client = createHttpClient()

    override suspend fun fetchItemList(): List<LbcItem> =
        client.get(FETCH_LIST_URL)
}

private const val FETCH_LIST_URL = "https://static.leboncoin.fr/img/shared/technical-test.json"

private fun createHttpClient() = HttpClient {

    install(JsonFeature) {
        serializer = KotlinxSerializer(
            Json {
                serializersModule = SerializersModule {}
                ignoreUnknownKeys = true
                isLenient = true
                coerceInputValues = true
            }
        )
    }
    install(Logging) {
        logger = Logger.DEFAULT
    }
}
