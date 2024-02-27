package com.example.myapplication.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {

     val BASE_URL = "https://api.themoviedb.org/3/movie/"

    val api : ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}