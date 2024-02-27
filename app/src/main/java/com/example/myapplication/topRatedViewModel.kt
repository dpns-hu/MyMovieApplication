package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Network.Datamodel.Responses
import com.example.myapplication.Network.Datamodel.Result
import com.example.myapplication.Network.RetrofitObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class topRatedViewModel: ViewModel() {

    private var movieLiveData = MutableLiveData<List<Result>>()
    fun getPopularMovies() {
        RetrofitObject.api.getTopRatedMovieList("69d66957eebff9666ea46bd464773cf0").enqueue(object  :
            Callback<Responses> {
            override fun onResponse(call: Call<Responses>, response: Response<Responses>) {
                if (response.body()!=null){
                    movieLiveData.value = response.body()!!.results

                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Responses>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }
    fun observeMovieLiveData() : LiveData<List<Result>> {
        return movieLiveData
    }
}