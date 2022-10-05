package com.mustafa.inviochallengemovieapp.service

import com.mustafa.inviochallengemovieapp.model.MovieDetailModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDetailAPI {

    @GET("/?&apikey=6cfaa5bb")
    suspend fun getDetailMovie(@Query(value = "i",encoded = true) i:String):MovieDetailModel

}