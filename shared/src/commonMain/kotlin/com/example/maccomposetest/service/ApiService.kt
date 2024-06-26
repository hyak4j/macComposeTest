package com.example.maccomposetest.service

import com.example.maccomposetest.model.PostModel

interface ApiService {
    suspend fun getPosts(): List<PostModel>
    // 定義更多 API ...
}
