package com.ceosilvajr.freemovieph

import android.app.Application
import com.squareup.leakcanary.LeakCanary

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
class FmpApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    LeakCanary.install(this)
  }
}