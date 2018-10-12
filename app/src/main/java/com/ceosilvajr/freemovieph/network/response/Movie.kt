package com.ceosilvajr.freemovieph.network.response

import com.google.gson.annotations.SerializedName

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
data class Movie(
    @SerializedName("vote_count") val voteCount: Int,
    val id: Int,
    val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Int,
    val title: String,
    val popularity: Double,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("genre_ids") val genreIds: ArrayList<Int>,
    @SerializedName("backdrop_path") val backdropPath: String,
    val adult: Boolean,
    val overview: String,
    @SerializedName("release_date") val releaseDate: String
)