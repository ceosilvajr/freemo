package com.ceosilvajr.freemovieph.network.response

import com.google.gson.annotations.SerializedName

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
data class FetchMoviesResponse(
    val page: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val movieResponses: ArrayList<MovieResponse>
)