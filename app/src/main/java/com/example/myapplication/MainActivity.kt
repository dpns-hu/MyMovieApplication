package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.Network.ApiInterface
import com.example.myapplication.Network.RetrofitObject
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

      val API = "38a73d59546aa378980a88b645f487fc"
    val baseImageUrl = "https://image.tmdb.org/t/p/w500"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = this.findNavController(R.id.fragment)
        binding.bottomNav.setupWithNavController(navController)


    }

//    private fun loadApi() {
//        val call = movieApiService.getNowPlayingMovies(
//            API,
//            page = currentPage
//        )
//
//        call.enqueue(object : Callback<Responses> {
//            override fun onResponse(call: Call<Responses>, response: Response<Responses>) {
//                if (response.isSuccessful) {
//                    val movieApiResponse = response.body()
//                    val movies = movieApiResponse?.results ?: emptyList()
//                    val containMovieList = mutableListOf<Result>()
//
//                    for(movie in movies){
//                        containMovieList.add(movie)
//                        Log.e("movieApiName","${movie.title} and ${movie.poster_path}")
//                    }
//                    Log.e("movieApiName",movieApiResponse?.total_pages.toString())
//
//                     list.addAll(containMovieList)
//                    updateRecyclerView(list)
//                    currentPage++
//
//
//                }else {
//                    Log.e("API Error", "Response not successful. Code: ${response.code()}")
//                }
//            }
//
//            override fun onFailure(call: Call<Responses>, t: Throwable) {
//                Log.e("API Error", "Failed to make API call: ${t.message}")
//            }
//        })
//    }



//    private fun updateRecyclerView(containMovieList: MutableList<Result>) {
//              val adapter = AdapterRv(this@MainActivity,containMovieList,baseImageUrl)
//        val layoutman = LinearLayoutManager(this)
//
//               binding.recyclerView.layoutManager = layoutman
//              binding.recyclerView.adapter = adapter
//
//            }
//



}

