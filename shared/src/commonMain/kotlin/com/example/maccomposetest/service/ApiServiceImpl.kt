package com.example.maccomposetest.service

import com.example.maccomposetest.model.PostModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class ApiServiceImpl : ApiService {
    private val BASE_URL = "https://jsonplaceholder.typicode.com"
    private val client = ApiClient.client
    override suspend fun getPosts(): List<PostModel> = withContext(Dispatchers.IO) {
       client.get("$BASE_URL/posts").body()
    }

    override suspend fun getPostsByPost(): List<PostModel> = withContext(Dispatchers.IO) {
        client.post("$BASE_URL/posts"){
            contentType(ContentType.Application.Json)
            setBody(PostModel(2, 123, "title", "body"))
        }.body()
    }


//    override suspend fun createUser(user: User): User = withContext(Dispatchers.IO) {
//        client.post("https://api.example.com/users") {
//            body = user
//        }
//    }

    // 實作更多 API ...
}