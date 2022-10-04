package com.mustafa.inviochallengemovieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mustafa.inviochallengemovieapp.databinding.RowMovieListBinding
import com.mustafa.inviochallengemovieapp.model.MovieModel
import com.mustafa.inviochallengemovieapp.model.Search

class MovieAdapter(
    private val movieList: ArrayList<Search>
) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {


    inner  class MovieHolder( val binding: RowMovieListBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding = RowMovieListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.binding.movie = movieList.get(position)

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun updateCountryList(newCountryList:ArrayList<Search>){
        movieList.clear()
        movieList.addAll(newCountryList)
        notifyDataSetChanged()
    }

}