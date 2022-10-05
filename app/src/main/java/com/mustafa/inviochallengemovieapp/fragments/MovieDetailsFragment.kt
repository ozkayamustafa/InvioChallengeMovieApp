package com.mustafa.inviochallengemovieapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import com.mustafa.inviochallengemovieapp.R
import com.mustafa.inviochallengemovieapp.databinding.FragmentMovieDetailsBinding
import com.mustafa.inviochallengemovieapp.viewmodel.MovieDetailsViewModel
import com.mustafa.inviochallengemovieapp.viewmodel.MoviewHomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {
     val viewModel: MovieDetailsViewModel by viewModels<MovieDetailsViewModel>()
     lateinit var binding: FragmentMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie_details,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.clicklable = this
        arguments?.let {
            val search = MovieDetailsFragmentArgs.fromBundle(it).searchModel
            search.imdbID?.let {
                viewModel.getDetailData(it)
            }
        }

        viewModel.moviewDetail.observe(viewLifecycleOwner, Observer {
            binding.data = it
        })

        circleProgress()
    }


    fun circleProgress(){
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it == true){
                binding.progress.visibility = View.VISIBLE
            }
            else{
                binding.progress.visibility = View.GONE
            }
        })

    }

    fun backToHome(view: View){
        Navigation.findNavController(view).popBackStack()
    }


}