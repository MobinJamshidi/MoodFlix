package com.example.moodflix.Data.remote

import com.example.moodflix.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieApi{
    @GET("3/discover/moview")
    suspend fun getMovieByGener(
        @Query("api_key") api_key: String,
        @Query("with_gener") generId: String,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): MovieResponse
}