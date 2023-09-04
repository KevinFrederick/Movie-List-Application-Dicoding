package com.kevinfre.movielistapplication

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MovieDetail : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = ""

        val imgDetailMoviePoster: ImageView = findViewById(R.id.img_detail_movie_poster)
        val tvDetailMovieTitle: TextView= findViewById(R.id.tv_detail_movie_title)
        val tvDetailMovieRating: TextView = findViewById(R.id.tv_detail_movie_rating)
        val tvDetailMovieDirectorName: TextView = findViewById(R.id.tv_detail_movie_director_name)
        val tvDetailMovieDescription: TextView = findViewById(R.id.tv_detail_movie_description)

        val movie = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Movie>(EXTRA_MOVIE, Movie::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_MOVIE)
        }

        if(movie != null){
            Glide.with(this)
                .load(movie.poster)
                .into(imgDetailMoviePoster)
            tvDetailMovieTitle.text = movie.title
            tvDetailMovieRating.text = movie.rating
            tvDetailMovieDirectorName.text = movie.director
            tvDetailMovieDescription.text = movie.description
        }
    }
}