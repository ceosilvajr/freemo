package com.ceosilvajr.freemovieph.views

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ceosilvajr.freemovieph.R

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
class MarginDecoration(context: Context) : RecyclerView.ItemDecoration() {

  private var margin: Int = 0

  init {
    margin = context.resources.getDimensionPixelSize(R.dimen.item_margin)
  }

  override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
    outRect.set(margin, margin, margin, margin)
  }
}