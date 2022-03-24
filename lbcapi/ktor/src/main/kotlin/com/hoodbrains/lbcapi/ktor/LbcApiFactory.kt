package com.hoodbrains.lbcapi.ktor

import com.hoodbrains.lbcapi.LbcApi
import com.hoodbrains.lbcapi.ktor.internal.LbcApiKtorImpl

fun createApi(): LbcApi = LbcApiKtorImpl()