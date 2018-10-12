package com.ceosilvajr.freemovieph.models

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
data class Movie(
    val id: Int? = 0,
    val voteCount: Int? = 0,
    val title: String? = "",
    val popularity: Double? = 0.0,
    val posterPath: String? = "",
    val overview: String? = "",
    val releaseDate: String? = ""
)