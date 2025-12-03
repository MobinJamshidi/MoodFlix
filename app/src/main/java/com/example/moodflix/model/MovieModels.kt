package com.example.moodflix.model

import com.example.moodflix.utils.Constants
import com.google.gson.annotations.SerializedName

data class MovieResponse (
    val result : List<MovieDto>
)


data class MovieDto(
    val id : Int,
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String?
){
    val fullPosterUrl: String
        get() = if (posterPath != null) "${Constants.IMAGE_BASE_URL}$posterPath" else ""
}