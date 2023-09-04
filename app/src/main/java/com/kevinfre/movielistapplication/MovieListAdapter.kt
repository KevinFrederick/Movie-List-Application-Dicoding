package com.kevinfre.movielistapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieListAdapter(private val listMovie: ArrayList<Movie>) : RecyclerView.Adapter<MovieListAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val imgPoster: ImageView = itemView.findViewById(R.id.img_item_poster)
        val tvRating: TextView = itemView.findViewById(R.id.tv_item_rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_row_item, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount() = listMovie.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, poster, rating) = listMovie[position]
        holder.tvTitle.text = title
        holder.tvDescription.text = description
        Glide.with(holder.itemView.context)
            .load(poster)
            .into(holder.imgPoster)
        holder.tvRating.text = rating

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, MovieDetail::class.java)
            intentDetail.putExtra(MovieDetail.EXTRA_MOVIE, listMovie[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}