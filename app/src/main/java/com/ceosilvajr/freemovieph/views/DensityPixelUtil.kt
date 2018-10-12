package com.ceosilvajr.freemovieph.views

import android.content.Context

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
object DensityPixelUtil {

  fun toDensityPixel(dp: Int, context: Context): Int {
    val metrics = context.resources.displayMetrics
    return (metrics.density * dp).toInt()
  }
}