package com.ceosilvajr.freemovieph.interactor

import com.ceosilvajr.freemovieph.BuildConfig
import com.ceosilvajr.freemovieph.network.ApiService
import com.ceosilvajr.freemovieph.network.response.FetchMoviesResponse
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**-
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
private const val API_KEY = BuildConfig.API_KEY
private const val LANGUAGE = "en-US"
private const val REGION = "PH"
private const val SORT_BY = "popularity.desc"
private const val INCLUDE_ADULT = false
private const val INCLUDE_VIDEO = false

object MoviesInteractor {

  fun fetchPopularMovies(page: Int): Flowable<FetchMoviesResponse> {
    val params = HashMap<String, Any>()
    params["api_key"] = API_KEY
    params["language"] = LANGUAGE
    params["region"] = REGION
    params["sort_by"] = SORT_BY
    params["include_adult"] = INCLUDE_ADULT
    params["include_video"] = INCLUDE_VIDEO
    params["page"] = page
    return ApiService.create().getMovies(params).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
  }
}