package com.ceosilvajr.freemovieph.basemvp

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
open class BaseFragment : Fragment() {

  val compositeDisposable = CompositeDisposable()

  override fun onDestroyView() {
    super.onDestroyView()
    compositeDisposable.clear()
  }
}