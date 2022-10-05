package com.mustafa.inviochallengemovieapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafa.inviochallengemovieapp.model.MovieDetailModel
import com.mustafa.inviochallengemovieapp.repository.MovieDetailRepository
import com.mustafa.inviochallengemovieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel
    @Inject
    constructor(
        private val repository: MovieDetailRepository
    ) : ViewModel(){


        var moviewDetail = MutableLiveData<MovieDetailModel>()
        var isLoading = MutableLiveData<Boolean>()

    init {
        isLoading.value = false
    }


    fun getDetailData(s:String){
        isLoading.value = true
        viewModelScope.launch {
            val result = repository.getDetailData(s)
            when(result){
               is Resource.Success->{
                        result.data?.let {
                            moviewDetail.value = it
                        }
                   isLoading.value = false
               }
                is Resource.Error ->{
                    isLoading.value = false
                }
            }

        }


    }




}