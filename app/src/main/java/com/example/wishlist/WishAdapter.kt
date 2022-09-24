package com.example.wishlist


import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishAdapter (private val wish: List<Wish>) : RecyclerView.Adapter<WishAdapter.ViewHolder>(){
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val urlTextView: TextView
        val titleTextView: TextView
        val priceTextView: TextView

        // TODO: Create member variables for any view that will be set
        // as you render a row.

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            titleTextView = itemView.findViewById(R.id.itemTitle)
            priceTextView = itemView.findViewById(R.id.itemPrice)
            urlTextView = itemView.findViewById(R.id.itemURL)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wish_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val wishes = wish[position]
        // Set item views based on views and data model
        holder.titleTextView.text = wishes.title
        holder.priceTextView.text = wishes.price
        holder.urlTextView.text = wishes.link
/*
        val isEmailRead = email.isRead
        if (!isEmailRead){
            holder.senderTextView
                .setTypeface(holder.senderTextView.typeface, Typeface.BOLD )
        }
        if (!isEmailRead){
            holder.titleTextView
                .setTypeface(holder.titleTextView.typeface, Typeface.BOLD )
        }
        if (!isEmailRead){
            holder.summaryTextView
                .setTypeface(holder.summaryTextView.typeface, Typeface.BOLD )
        }
    }

 */
    }

    override fun getItemCount(): Int {
        return wish.size
    }

}