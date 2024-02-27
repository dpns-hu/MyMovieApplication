package com.example.myapplication.Network

import com.example.myapplication.Network.Datamodel.Responses
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query




interface ApiInterface {
    @GET("popular?")
      fun getPopularMovieList(
        @Query("api_key") apiKey: String
            ):Call<Responses>


    @GET("top_rated?")
    fun getTopRatedMovieList(
        @Query("api_key") apiKey: String
    ):Call<Responses>
}
