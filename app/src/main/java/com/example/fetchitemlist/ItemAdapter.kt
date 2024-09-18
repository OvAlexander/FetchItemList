package com.example.fetchitemlist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * This ItemAdapter class manages the presentation of [Item] objects within a RecyclerView.
 */
class ItemAdapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
        /**
         * A ViewHolder class that holds the references to the views for each item in the list.
         */
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val listIdTextView : TextView = itemView.findViewById(R.id.listIdTextView)
            val itemNameTextView : TextView = itemView.findViewById(R.id.itemNameTextView)

        }
        /**
         * Creates a new ViewHolder instance by inflating the layout for a single item.
         *
         * @param parent The ViewGroup where the new View will be added.
         * @param viewType The view type of the new View.
         * @return A new ViewHolder that holds
        the inflated view.
         */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
            return ViewHolder(view)
        }

        /**
         * Binds the data from an [Item] object to the corresponding views in the ViewHolder at the specified position.
         *
         * @param holder The ViewHolder that holds the views to be bound.
         * @param position The position of the item in the list.
         */
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = itemList[position]
            if (item != null) {
                holder.listIdTextView.text = item.listId.toString()
                holder.itemNameTextView.text = item.name
            } else {
                Log.e("ItemAdapter", "Item returned null at position $position")
            }
        }
        /**
         * Returns the total number of items in the list.
         *
         * @return The size of the [itemList].
         */
        override fun getItemCount() = itemList.size
    }