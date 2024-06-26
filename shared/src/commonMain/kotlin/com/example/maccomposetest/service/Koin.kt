package com.example.maccomposetest.service

import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single<ApiService> { ApiServiceImpl() }
}

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}
