package com.example.maccomposetest.service

import com.example.maccomposetest.model.PostModel

interface ApiService {
    suspend fun getPosts(): List<PostModel>

    suspend fun getPostsByPost(): List<PostModel>
    // 定義更多 API ...
}
