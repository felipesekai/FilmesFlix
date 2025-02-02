package com.br.natanfc.filmesflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.br.natanfc.filmesflix.model.Movie
import com.br.natanfc.filmesflix.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var movieListViewModel : MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieListViewModel = ViewModelProvider.NewInstanceFactory()
            .create(MovieListViewModel::class.java)
        movieListViewModel.init()

        initObserver()

    }

    private fun initObserver(){
        movieListViewModel.movieslist.observe(
            this, Observer { list->
                populateListMovie(list)
            }
        )
    }

    private fun populateListMovie(list: List<Movie>) {
        moviesList.apply {
            hasFixedSize()
             adapter = MoviesAdapter(list)
        }
    }
}