package com.example.retrofitapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/aarti")
    fun getAarti() : Call<UserModel>

    @GET("/chalisa")
    fun getChalisa() : Call<UserModel>


}