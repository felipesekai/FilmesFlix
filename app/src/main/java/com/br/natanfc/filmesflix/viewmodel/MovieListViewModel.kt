package com.br.natanfc.filmesflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.natanfc.filmesflix.model.Movie

class MovieListViewModel : ViewModel() {
    private var  _movieslist = MutableLiveData<List<Movie>>()
    val movieslist: LiveData<List<Movie>>
    get() = _movieslist
    private  val listMovie = arrayListOf(
        Movie(
            id = 0,
            titulo = "Titanic",
            imagem = null,
            null,
            null
        ),
        Movie(
            id = 1,
            titulo = "Central do Brasil",
            imagem = null,
            null,
            null
        ),
    )

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        _movieslist.value = listMovie
    }
}