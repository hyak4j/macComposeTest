package com.example.maccomposetest

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform