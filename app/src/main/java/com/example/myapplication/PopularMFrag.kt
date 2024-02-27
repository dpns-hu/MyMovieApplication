package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.MyAdapters.AdapterRv
import com.example.myapplication.Network.RetrofitObject

import com.example.myapplication.databinding.FragmentPopularMBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class PopularMFrag : Fragment() {
lateinit var binding : FragmentPopularMBinding
    private lateinit var movieAdapter : AdapterRv
    private lateinit var viewModel: MainViewModel
    val api_key = "6855f7647be92fefa927a78162299eed"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPopularMBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(viewLifecycleOwner, Observer { movieList ->

            movieAdapter.setMovieList(movieList)
        })
    }


    private fun prepareRecyclerView() {
        movieAdapter = AdapterRv(requireContext())
        binding.rv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = movieAdapter
        }
    }
}
