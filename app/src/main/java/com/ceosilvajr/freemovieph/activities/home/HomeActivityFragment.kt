package com.ceosilvajr.freemovieph.activities.home

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ceosilvajr.freemovieph.R
import com.ceosilvajr.freemovieph.adapters.MovieGridAdapter
import com.ceosilvajr.freemovieph.basemvp.BaseFragment
import com.ceosilvajr.freemovieph.models.Movie
import com.ceosilvajr.freemovieph.views.MarginDecoration
import kotlinx.android.synthetic.main.fragment_home.*

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
private const val ADAPTER_POSITION_SUBTRACTOR = 1
class HomeActivityFragment : BaseFragment(), HomeView {

  private lateinit var homePresenter: HomePresenter
  private lateinit var movieViewAdapter: MovieGridAdapter
  private var listener: Listener? = null
  private var pageNumber = 1

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    if (context is Listener) {
      listener = context
    } else {
      throw ClassCastException(context.toString() + " must implement HomeActivityFragment.Listener.")
    }
  }

  override fun onDetach() {
    super.onDetach()
    listener = null
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    homePresenter = HomePresenter(this)
    movieViewAdapter = MovieGridAdapter(ArrayList(), context!!)
    return inflater.inflate(R.layout.fragment_home, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    rv_movies.addItemDecoration(MarginDecoration(context!!))
    rv_movies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
      override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val gridLayoutManager = rv_movies.layoutManager as GridLayoutManager
        if (gridLayoutManager.findLastVisibleItemPosition() == gridLayoutManager.itemCount - ADAPTER_POSITION_SUBTRACTOR) {
          pageNumber++
          compositeDisposable.add(homePresenter.fetchMovies(pageNumber))
        }
      }
    })
    rv_movies.adapter = movieViewAdapter
    compositeDisposable.add(homePresenter.fetchMovies(pageNumber))
  }

  override fun displayMovies(movies: ArrayList<Movie>) {
    movieViewAdapter.updateMovies(movies)
  }

  override fun onErrorFetchingMovies(message: String) = listener!!.onErrorFetchingMovies(message)

  override fun showLoading() {
    pb_home.visibility = View.VISIBLE
  }

  override fun dismissLoading() {
    pb_home.visibility = View.GONE
  }

  interface Listener {
    fun onErrorFetchingMovies(message: String)
  }
}