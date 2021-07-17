package com.example.mypost

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CommentsAdapter(var commentsList:List<Comment>,var context: Context):RecyclerView.Adapter<CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
      val itemView=LayoutInflater.from(parent.context).inflate(R.layout.comment_list_item,parent,false)
        return  CommentsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
       val currentComment=commentsList.get(position)
        holder.tvName.text=currentComment.name
        holder.tvEmail.text=currentComment.email

        }

    override fun getItemCount(): Int {
        return commentsList.size
    }
    }

class CommentsViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvEmail= itemView.findViewById<TextView>(R.id.tvEmail)
    var tvBody2=itemView.findViewById<TextView>(R.id.tvBody2)
    var tvId2=itemView.findViewById<TextView>(R.id.tvId2)
    var cvComments=itemView.findViewById<CardView>(R.id.cvComments)
}