package com.ceosilvajr.freemovieph.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ceosilvajr.freemovieph.BuildConfig
import com.ceosilvajr.freemovieph.R
import com.ceosilvajr.freemovieph.models.Movie
import com.ceosilvajr.freemovieph.views.DensityPixelUtil
import kotlinx.android.synthetic.main.item_movie_card.view.*

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
private const val IMAGE_DP_CORNER_SIZE = 10
private const val DEFAULT_RATING_VALUE = 0f

class MovieGridAdapter(private val items: ArrayList<Movie>,
    private val context: Context) : RecyclerView.Adapter<MovieGridAdapter.AdapterViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
    return AdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie_card, parent, false))
  }

  fun updateMovies(newList: ArrayList<Movie>) {
    items.addAll(newList)
    notifyDataSetChanged()
  }

  override fun getItemCount() = items.size

  override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
    val movie = items[position]
    Glide.with(context)
        .load(BuildConfig.IMAGE_BASE_URL + movie.posterPath)
        .apply(RequestOptions().transforms(CenterCrop(),
            RoundedCorners(DensityPixelUtil.toDensityPixel(IMAGE_DP_CORNER_SIZE, context))))
        .into(holder.ivPhoto)
    holder.rtStars.rating = movie.popularity?.toFloat() ?: DEFAULT_RATING_VALUE
    holder.tvTitle.text = movie.title
  }

  inner class AdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivPhoto = view.iv_movie_photo!!
    val rtStars = view.rt_movie_stars!!
    val tvTitle = view.tv_movie_name!!
  }
}