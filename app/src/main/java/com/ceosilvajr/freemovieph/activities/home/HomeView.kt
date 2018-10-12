package com.ceosilvajr.freemovieph.activities.home

import com.ceosilvajr.freemovieph.basemvp.BaseView
import com.ceosilvajr.freemovieph.models.Movie

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
interface HomeView : BaseView {
  fun displayMovies(movies: ArrayList<Movie>)
  fun onErrorFetchingMovies(message: String)
}