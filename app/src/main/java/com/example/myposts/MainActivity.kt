package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var tvuserId: TextView
    lateinit var tvId: TextView
    lateinit var tvTitle: TextView
    lateinit var tvBody: TextView
    lateinit var rvPosts: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvuserId = findViewById(R.id.tvuserId)
        tvId = findViewById(R.id.tvId)
        tvTitle = findViewById(R.id.tvTitle)
        tvBody = findViewById(R.id.tvBody)
        rvPosts = findViewById(R.id.rvPosts)

        getPosts()
    }

    fun getPosts() {
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = retrofit.getPosts()
        request.enqueue(object : retrofit2.Callback<List<Post>?> {
            override fun onResponse(call: Call<List<Post>?>, response: Response<List<Post>?>) {
                if (response.isSuccessful){
                    var posts = response.body()!!
                    rvPosts.layoutManager =LinearLayoutManager(baseContext)
                    var postsAdapter = PostsAdapter(posts)
                    rvPosts.adapter = postsAdapter

                }
            }

            override fun onFailure(call: Call<List<Post>?>, t: Throwable) {

            }
        })

        }
    }