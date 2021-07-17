package com.example.mypost

import   retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {
  @GET("posts")
  fun getPosts():Call <List<Post>>
  @GET("posts/{postId}")
  fun getPost(@Path("PostId")id:Int):Call<Post>
  @GET("posts,{postId}/comments")
  fun getComment(@Path("CommentId")id: Int):Call<Comment>
  //in post comments it will be posts/postComment
 }


