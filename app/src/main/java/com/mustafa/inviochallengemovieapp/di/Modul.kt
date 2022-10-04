package com.mustafa.inviochallengemovieapp.di

import com.mustafa.inviochallengemovieapp.repository.IMovieSearchRepository
import com.mustafa.inviochallengemovieapp.repository.MovieSearchRepository
import com.mustafa.inviochallengemovieapp.service.MovieAPI
import com.mustafa.inviochallengemovieapp.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Modul {

    @Singleton
    @Provides
    fun provideMoviewApi():MovieAPI{
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MovieAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideMovieRepository(api:MovieAPI):IMovieSearchRepository{
        return MovieSearchRepository(api)
    }

}