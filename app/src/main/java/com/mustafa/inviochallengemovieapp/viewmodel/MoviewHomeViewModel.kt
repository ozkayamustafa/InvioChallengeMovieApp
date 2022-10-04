package com.mustafa.inviochallengemovieapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafa.inviochallengemovieapp.model.MovieModel
import com.mustafa.inviochallengemovieapp.repository.MovieSearchRepository
import com.mustafa.inviochallengemovieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviewHomeViewModel
@Inject constructor( val repository: MovieSearchRepository) : ViewModel() {

    var movieListData = MutableLiveData<MovieModel>()
    var isLoanding = MutableLiveData<Boolean>()
    var error = MutableLiveData<String>()

    init {
        isLoanding.value = false
    }

    fun getSearchData(s:String){
        isLoanding.value = true
        viewModelScope.launch {
            var result = repository.getMovieList(s)
            when(result){
                is Resource.Success ->{
                    result.data?.let {
                        movieListData.value = it
                    }
                    error.value = ""
                    isLoanding.value = false
                }
                is Resource.Error->{
                        result.message?.let {
                            error.value = it
                        }
                    isLoanding.value = false
                }
            }

        }
    }

}