package com.mustafa.inviochallengemovieapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.mustafa.inviochallengemovieapp.R
import com.mustafa.inviochallengemovieapp.adapter.MovieAdapter
import com.mustafa.inviochallengemovieapp.databinding.FragmentMovieHomeBinding
import com.mustafa.inviochallengemovieapp.model.MovieModel
import com.mustafa.inviochallengemovieapp.viewmodel.MoviewHomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieHomeFragment : Fragment() {
    val  viewModel:MoviewHomeViewModel  by viewModels<MoviewHomeViewModel>()

    private lateinit var binding: FragmentMovieHomeBinding
    private lateinit var adapter:MovieAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MovieAdapter(arrayListOf())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie_home,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.clicklable = this
       /// adapter = MovieAdapter(arrayListOf())
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        viewModel.movieListData.observe(viewLifecycleOwner, Observer {
            if (it.Search.size == 0){
                binding.errorLayout.visibility = View.VISIBLE
                binding.errorText.text = "Üzgünüz! Aradığınız Filmi Bulamadık"
            }
            else{
                binding.errorLayout.visibility = View.GONE
            }
             it?.let {
                 adapter.updateCountryList(it.Search)
             }
        })


    }

    fun onSearchClick(view: View){
        circleProgress()
        val value = binding.movieName.text.toString()

         value?.let {
             viewModel.getSearchData(it.trim())
         }

    }

    private fun circleProgress(){  // Progress Kontrolu
       viewModel.isLoanding.observe(viewLifecycleOwner, Observer {
            if (it == true){
                binding.progress.visibility = View.VISIBLE
            }
           else{
                binding.progress.visibility = View.GONE
            }
       })
    }

}