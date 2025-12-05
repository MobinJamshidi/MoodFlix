package com.example.moodflix.data.remote

import com.example.moodflix.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("3/discover/movie")
    suspend fun getMoviesByGenre(
        @Query("api_key") apiKey: String,
        @Query("with_genres") genreIds: String,
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("page") page: Int
    ): MovieResponse
}