package com.example.foodorder.Retrofit

import retrofit2.http.GET

interface FoodApi {
    @GET("categories.php")
    suspend fun getCategories(): ListCategories
}