package com.mustafa.inviochallengemovieapp.repository

import com.mustafa.inviochallengemovieapp.model.MovieDetailModel
import com.mustafa.inviochallengemovieapp.service.MovieDetailAPI
import com.mustafa.inviochallengemovieapp.util.Resource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class MovieDetailRepository
@Inject
constructor(private val api:MovieDetailAPI) : IMovieDetailRepository{
    override suspend fun getDetailData(s: String): Resource<MovieDetailModel> {
        val result = try {
                api.getDetailMovie(s)
        }catch (e:Exception){
            return Resource.Error(e.message.toString())
        }
        return Resource.Success(result)
    }
}