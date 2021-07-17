package com.example.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class CommentsActivity : AppCompatActivity() {
    var postId=0
    lateinit var tvPostTitle:TextView
    lateinit var  tvPostBody:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)
        postId=intent.getIntExtra("POST_ID", 0)
        castViews()
        getPost()
        getComments()
    }
    fun castViews(){
        tvPostTitle=findViewById(R.id.tvPostTitle)
        tvPostBody=findViewById(R.id.tvPostBody)

    }
    fun getPost(){
        if (postId==0){
           Toast.makeText(baseContext,"post not found",Toast.LENGTH_LONG).show()
            finish()
        }
        var apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=apiClient.getPost(postId)
        request.enqueue(object :Callback<Post?>{
            override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
             if(response.isSuccessful){
                 var posts=response.body()
                 tvPostTitle.text=posts?.title
                 tvPostBody.text=posts?.body
             }
            }

     override fun onFailure(call: Call<Post?>,t:Throwable){
         Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
}
        })
    }
}
    fun getComments() {
        var rvComments= findViewById<RecyclerView>(R.id.rvComments)
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = retrofit.getComment(po)
        request.enqueue(object :Callback<List<Comment>>{

            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if (response.isSuccessful) {
                    var comments = response.body()!!
                    var commentsAdapter = CommentsAdapter(comments, baseContext)
                    rvComments.layoutManager=LinearLayoutManager(baseContext)
                    rvComments.adapter = commentsAdapter


                }

            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }




