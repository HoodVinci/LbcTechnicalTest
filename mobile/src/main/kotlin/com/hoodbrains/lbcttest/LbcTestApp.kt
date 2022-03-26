package com.hoodbrains.lbcttest

import android.app.Application
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity

class LbcTestApp : Application() {

    lateinit var appDependenciesProvider: AppDependenciesProvider

    override fun onCreate() {
        appDependenciesProvider = AppDependenciesProvider(this)
        super.onCreate()
    }
}

@MainThread
internal inline fun <reified T> AppCompatActivity.app(noinline block: AppDependenciesProvider.() -> T): Lazy<T> =
    lazy { (application as LbcTestApp).appDependenciesProvider.block() }

