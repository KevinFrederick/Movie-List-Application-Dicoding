package com.kevinfre.movielistapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val title: String,
    val description: String,
    val poster: String,
    val rating: String
) : Parcelable
