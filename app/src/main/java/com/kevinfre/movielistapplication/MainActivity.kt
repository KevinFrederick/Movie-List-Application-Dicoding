package com.kevinfre.movielistapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMovies: RecyclerView
    private val list = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.rv_Movies)
        rvMovies.setHasFixedSize(true)

        list.addAll(getListMovies())
        showRecyclerList()
    }

    private fun getListMovies(): ArrayList<Movie>{
        val moviesTitle = resources.getStringArray(R.array.movies_title)
        val moviesDescription = resources.getStringArray(R.array.movies_description)
        val moviesPoster = resources.getStringArray(R.array.movies_poster)
        val moviesRating = resources.getStringArray(R.array.movies_rating)
        val listMovie = ArrayList<Movie>()
        for (i in moviesTitle.indices){
            val movie = Movie(moviesTitle[i], moviesDescription[i], moviesPoster[i], moviesRating[i])
            listMovie.add(movie)
        }
        return listMovie
    }

    private fun showRecyclerList(){
        rvMovies.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = MovieListAdapter(list)
        rvMovies.adapter = listHeroAdapter
    }
}