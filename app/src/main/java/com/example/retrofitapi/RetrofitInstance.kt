package com.example.retrofitapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance  {



    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://my-bhakti-api.onrender.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }


}