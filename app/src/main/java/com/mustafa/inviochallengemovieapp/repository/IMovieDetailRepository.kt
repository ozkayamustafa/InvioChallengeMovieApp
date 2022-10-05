package com.mustafa.inviochallengemovieapp.repository

import com.mustafa.inviochallengemovieapp.model.MovieDetailModel
import com.mustafa.inviochallengemovieapp.util.Resource

interface IMovieDetailRepository {
    suspend fun getDetailData(s:String):Resource<MovieDetailModel>
}