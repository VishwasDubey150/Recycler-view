package com.example.newsfeed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class newslistAdapter(private val items:ArrayList<String>,private val listener:NewsItemClicked) :RecyclerView.Adapter<NewsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val viewHolder=NewsViewHolder(view)
        view.setOnClickListener {
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        var currentItem=items[position]
        holder.name.text=currentItem
    }


    override fun getItemCount(): Int {
        return items.size
    }
}


class NewsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
{
    var name:TextView=itemView.findViewById(R.id.name)
}

interface NewsItemClicked{
    fun onItemClicked(item:String)
}