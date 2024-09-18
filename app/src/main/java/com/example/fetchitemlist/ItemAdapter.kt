package com.example.fetchitemlist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val listIdTextView : TextView = itemView.findViewById(R.id.listIdTextView)
            val itemNameTextView : TextView = itemView.findViewById(R.id.itemNameTextView)

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = itemList[position]
            if (item != null) {
                holder.listIdTextView.text = item.listId.toString()
                holder.itemNameTextView.text = item.name
            } else {
                Log.e("ItemAdapter", "Item returned null at position $position")
            }
        }
    }