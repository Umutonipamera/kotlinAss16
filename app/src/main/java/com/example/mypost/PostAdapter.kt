package com.example.mypost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.cardview.widget.CardView

import androidx.recyclerview.widget.RecyclerView


class PostAdapter(var postsList:List<Post>,var context: Context):RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.post_list_item, parent, false)
        return PostsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val currentPost = postsList.get(position)
        holder.tvTitle.text=currentPost.title
        holder.tvBody.text = currentPost.body
       holder.cvPosts.setOnClickListener {
           var intent = Intent(context,CommentsActivity::class.java)
           intent.putExtra("post_id", currentPost.id)
           intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
          context.startActivity(intent)
    }

}

    override fun getItemCount():Int{
    return postsList.size
}
}

class PostsViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {



    var tvUserId=itemView.findViewById<TextView>(R.id.tvUserId)
    var tvId=itemView.findViewById<TextView>(R.id.tvId)
    var tvTitle=itemView.findViewById<TextView>(R.id.tvTitle)
    var tvBody=itemView.findViewById<TextView>(R.id.tvBody)
    var cvPosts =itemView.findViewById<CardView>(R.id.cvPosts)


    }





















