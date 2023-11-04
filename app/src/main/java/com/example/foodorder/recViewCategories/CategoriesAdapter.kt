package com.example.foodorder.recViewCategories

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorder.R
import com.example.foodorder.data_classes.TitleCategory

class CategoriesAdapter(private var categoryList: List<TitleCategory>) :
    RecyclerView.Adapter<CategoriesAdapter.CategViewHolder>() {
    class CategViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleCategory: TextView = itemView.findViewById(R.id.name_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_category, parent, false)
        Log.d("my_tag", "Inside the onCreateViewHolder fun")

        return CategViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategViewHolder, position: Int) {
        Log.d("my_tag", "Inside the onBindViewHolder fun")
        val curItem = categoryList[position]
        holder.titleCategory.text = curItem.title
    }

    override fun getItemCount(): Int {
        Log.d("my_tag", "Inside the getItemCount fun ${categoryList.size}")

        return categoryList.size
    }
}