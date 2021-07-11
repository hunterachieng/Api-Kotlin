package com.example.myposts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class PostsAdapter (var postList: List<Post>):RecyclerView.Adapter<PostsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
       var itemView = LayoutInflater.from(parent.context).inflate(R.layout.my_post,parent,false)
        return PostsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
       var currentPosts = postList.get(position)
        holder.tvuserId.text = currentPosts.userId.toString()
        holder.tvId.text = currentPosts.id.toString()
        holder.tvTitle.text =currentPosts.title
        holder.tvBody.text = currentPosts.body
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}
class PostsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvuserId = itemView.findViewById<TextView>(R.id.tvuserId)
    var tvId = itemView.findViewById<TextView>(R.id.tvId)
    var tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    var tvBody = itemView.findViewById<TextView>(R.id.tvBody)


}