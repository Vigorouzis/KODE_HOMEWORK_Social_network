package com.example.pc.kode_homework_social_network

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FeedAdapter(private val feedList: List<Feed>) :
    RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.feed_item, parent, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val new = feedList[position]
        if (new.type == "News") {
            Glide.with(holder.itemView.context).load(new.img).apply(RequestOptions.centerCropTransform())
                .into(holder.imageView)

            holder.iconView.visibility = View.GONE

        } else {
            Glide.with(holder.itemView.context).load(new.img).apply(RequestOptions.centerCropTransform())
                .into(holder.iconView)

            holder.imageView.visibility = View.GONE
        }
        holder.nameView.text = new.name
        holder.textView.text = new.text

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = feedList.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconView: ImageView = view.findViewById(R.id.avatar) as ImageView
        val imageView: ImageView = view.findViewById(R.id.image) as ImageView
        val nameView: TextView = view.findViewById(R.id.name)
        val textView: TextView = view.findViewById(R.id.text)


    }
}