package com.mustafa.inviochallengemovieapp.repository

import com.mustafa.inviochallengemovieapp.model.MovieModel
import com.mustafa.inviochallengemovieapp.util.Resource

interface IMovieSearchRepository {
    suspend fun getMovieList(s:String):Resource<MovieModel>
}