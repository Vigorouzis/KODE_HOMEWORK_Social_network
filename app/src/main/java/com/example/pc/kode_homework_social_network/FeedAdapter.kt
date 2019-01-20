package com.example.pc.kode_homework_social_network

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class FeedAdapter(val feedList: List<Feed>): RecyclerView.Adapter<FeedAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val feeds = feedList[position]

        holder.title.text = feeds.title
        holder.text.text = feeds.text
        holder.imageView.setImageResource(feeds.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = feedList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.title)
        val text: TextView = itemView.findViewById(R.id.news)
        val imageView: ImageView = itemView.findViewById(R.id.img_news)

    }
}