package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.MyAdapters.AdapterRv
import com.example.myapplication.databinding.FragmentTopRatedMBinding


class TopRatedMFrag : Fragment() {
 private lateinit var binding : FragmentTopRatedMBinding

    private lateinit var movieAdapter : AdapterRv
    private lateinit var viewModel: topRatedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTopRatedMBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[topRatedViewModel::class.java]
        viewModel.getPopularMovies()

        viewModel.observeMovieLiveData().observe(viewLifecycleOwner, Observer { movieList ->

            movieAdapter.setMovieList(movieList)
        })
    }

    private fun prepareRecyclerView() {
        movieAdapter = AdapterRv(requireContext())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = movieAdapter
        }
    }


}