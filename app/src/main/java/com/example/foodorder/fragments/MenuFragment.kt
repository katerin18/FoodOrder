package com.example.foodorder.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorder.R
import com.example.foodorder.Retrofit.FoodApi
import com.example.foodorder.data_classes.TitleCategory
import com.example.foodorder.recViewCategories.CategoriesAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val foodApi = retrofit.create(FoodApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val listCategories =
                foodApi.getCategories().categories.map { TitleCategory(it.strCategory) }
            launch(Dispatchers.Main) {
                val adapter = CategoriesAdapter(listCategories)
                val recView: RecyclerView = view.findViewById(R.id.rec_categories)
                val layoutManager = LinearLayoutManager(context)

                layoutManager.orientation = LinearLayoutManager.HORIZONTAL
                recView.layoutManager = layoutManager
                recView.adapter = adapter
            }
        }
    }
}