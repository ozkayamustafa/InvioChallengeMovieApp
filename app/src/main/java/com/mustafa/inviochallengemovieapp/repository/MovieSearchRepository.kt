package com.mustafa.inviochallengemovieapp.repository

import com.mustafa.inviochallengemovieapp.model.MovieModel
import com.mustafa.inviochallengemovieapp.service.MovieAPI
import com.mustafa.inviochallengemovieapp.util.Resource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject
import javax.inject.Singleton

@ActivityRetainedScoped
class MovieSearchRepository @Inject constructor ( private val api:MovieAPI) : IMovieSearchRepository {
    override suspend fun getMovieList(s:String): Resource<MovieModel> {
        val response = try {
                api.getAllMovie(s)
        }catch(e:Exception){
            return Resource.Error(e.message.toString())
        }
        return Resource.Success(response)
    }


}