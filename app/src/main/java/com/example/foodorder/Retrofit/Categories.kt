package com.example.foodorder.Retrofit

data class ListCategories(
    val categories: List<Categories>
)
data class Categories(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)
