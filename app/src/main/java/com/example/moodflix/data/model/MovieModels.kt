package com.example.moodflix.data.model

import com.example.moodflix.utils.Constants
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val results: List<MovieDto>
)

data class MovieDto(
    val id: Int,
    val title: String,

    @SerializedName("poster_path")
    val posterPath: String?,

    // 👇 این خط جدید است که باید اضافه شود تا ارور رفع شود
    @SerializedName("vote_average")
    val rating: Double
) {
    val fullPosterUrl: String
        get() = if (posterPath != null) "${Constants.IMAGE_BASE_URL}$posterPath" else ""
}