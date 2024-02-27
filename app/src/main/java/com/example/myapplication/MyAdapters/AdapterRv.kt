package com.example.myapplication.MyAdapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.Network.Datamodel.Result
import com.example.myapplication.databinding.RecyclerviewBinding



class AdapterRv(val context:Context) : RecyclerView.Adapter<AdapterRv.ViewHolder>() {
    private var movieList = ArrayList<Result>()
    interface OnShareClickListener {
        fun onShareClick(movie: Result)
    }

    // Share click listener
    private var shareClickListener: OnShareClickListener? = null

    // Function to set the movie list
    fun setMovieList(movieList: List<Result>) {
        this.movieList = ArrayList(movieList)
        notifyDataSetChanged()
    }

    // Function to set the share click listener
    fun setOnShareClickListener(listener: OnShareClickListener) {
        this.shareClickListener = listener
    }
    class ViewHolder(val binding: RecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerviewBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500" + movieList[position].poster_path)
            .into(holder.binding.movieImage)

        holder.binding.movieTittle.text = movieList[position].title
        holder.binding.Rating.text = "Rating- ${movieList[position].vote_average}"
        holder.binding.language.text = "Language- ${movieList[position].original_language}"
        holder.binding.releaseYear.text = "Year- ${movieList[position].release_date}"

        holder.binding.shareButton.setOnClickListener {
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val movie = movieList[position]
                shareMovieDetails(movie)
            }
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
    private fun shareMovieDetails(movie: Result) {
        val shareText = "Check out this movie: ${movie.title}\nRelease Date: ${movie.release_date}\nRating: ${movie.vote_average}"
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, shareText)
        context.startActivity(Intent.createChooser(intent, "Share Movie Details"))
    }
}