package com.example.maccomposetest

import PostRepository
import com.example.maccomposetest.model.PostModel

class Post {
    suspend fun getPostList(): List<PostModel>{
        val postRepository = PostRepository()
        val posts = postRepository.getPosts()
        return  posts
    }
}