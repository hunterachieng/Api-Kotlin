package com.example.myposts

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
    //connecting point of Rest Api and created interface
}
data class Post (var userId: Int, var id: Int, var title: String, var body:String)