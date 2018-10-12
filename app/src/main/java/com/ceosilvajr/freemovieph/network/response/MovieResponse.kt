package com.ceosilvajr.freemovieph.network.response

import com.google.gson.annotations.SerializedName

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
data class MovieResponse(
    @SerializedName("vote_count") val voteCount: Int? = 0,
    val id: Int? = 0,
    val video: Boolean? = false,
    @SerializedName("vote_average") val voteAverage: Double? = 0.0,
    val title: String? = "",
    val popularity: Double? = 0.0,
    @SerializedName("poster_path") val posterPath: String? = "",
    @SerializedName("original_language") val originalLanguage: String? = "",
    @SerializedName("original_title") val originalTitle: String? = "",
    @SerializedName("genre_ids") val genreIds: ArrayList<Int>?,
    @SerializedName("backdrop_path") val backdropPath: String? = "",
    val adult: Boolean? = false,
    val overview: String? = "",
    @SerializedName("release_date") val releaseDate: String? = ""
)