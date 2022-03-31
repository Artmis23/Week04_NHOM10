package com.example.login.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R
import com.example.login.model.DataStore
import com.example.login.model.Restaurant

class DataStoreAdapter(var dataSet: List<Restaurant>): RecyclerView.Adapter<DataStoreAdapter.DataStoreViewHolder>() {
    class DataStoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        companion object{
            fun from(parent: ViewGroup) : DataStoreViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_datastore, parent, false)
                return DataStoreViewHolder(view)
            }
        }
        fun bindData(restaurant: Restaurant) {
            val tvTitle = itemView.findViewById<TextView>(R.id.textView1)
            val tvDescription = itemView.findViewById<TextView>(R.id.textView2)
            val ivAvatar = itemView.findViewById<ImageView>(R.id.imageViewRcv)

            tvTitle.text = restaurant.name
            tvDescription.text = restaurant.diachi
            ivAvatar.setImageResource(restaurant.avatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataStoreViewHolder {
        return DataStoreViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: DataStoreViewHolder, position: Int) {
        val data = dataSet[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}