package com.ceosilvajr.freemovieph.activities.home

import com.ceosilvajr.freemovieph.basemvp.BasePresenter
import com.ceosilvajr.freemovieph.interactor.MoviesInteractor
import com.ceosilvajr.freemovieph.models.Movie
import com.ceosilvajr.freemovieph.network.exceptions.ServiceUnAvailableException
import com.ceosilvajr.freemovieph.network.exceptions.UnAuthorizeException
import io.reactivex.Flowable
import io.reactivex.disposables.Disposable

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
class HomePresenter(val view: HomeView) : BasePresenter() {

  fun fetchMovies(page: Int): Disposable {
    view.showLoading()
    return MoviesInteractor.fetchPopularMovies(page)
        .flatMap { return@flatMap Flowable.fromIterable(it.movieResponses) }
        .map { return@map Movie(it.id, it.voteCount, it.title, it.popularity, it.posterPath, it.overview) }
        .toList()
        .subscribe({
          view.displayMovies(it as ArrayList<Movie>)
          view.dismissLoading()
        }, {
          when (it) {
            is UnAuthorizeException -> view.onErrorFetchingMovies("Un Authorized access.")
            is ServiceUnAvailableException -> view.onErrorFetchingMovies("Server not available.")
            else -> view.onErrorFetchingMovies(it.message!!)
          }
          view.dismissLoading()
        })
  }
}