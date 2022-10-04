package com.mustafa.inviochallengemovieapp.service

import com.mustafa.inviochallengemovieapp.model.MovieModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {
    @GET("/?&apikey=6cfaa5bb")
    suspend fun getAllMovie(@Query(value = "s",encoded = true) name:String):MovieModel
}