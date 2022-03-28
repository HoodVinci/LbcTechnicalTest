package com.hoodbrains.lbcttest

import android.app.Application
import com.hoodbrains.lbcapi.ktor.createApi
import com.hoodbrains.lbctest.domain.UseCaseFactory
import com.hoodbrains.lbctest.local.simplefile.createLocalItemStore
import com.hoodbrains.lbctest.presentation.ViewModelFactory
import com.hoodbrains.lbctest.repositories.RepositoriesAssembler
import java.io.File

class AppDependenciesProvider(private val app: Application) {

    private val viewModelFactory: ViewModelFactory by lazy { createViewModelFactory() }

    fun providePresentationFactory(): ViewModelFactory = viewModelFactory


    private fun createViewModelFactory(): ViewModelFactory =
        ViewModelFactory(createUseCaseFactory(), createResources())

    private fun createResources() = ResourcesFactoryImpl(app)
    private fun createUseCaseFactory() = UseCaseFactory(RepositoriesAssembler(createApi(), createLocal()))

    private fun createLocal() = createLocalItemStore(File(app.filesDir.absolutePath, "local.json").absolutePath)
}

