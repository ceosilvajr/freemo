package com.ceosilvajr.freemovieph.activities.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ceosilvajr.freemovieph.R
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.alert

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
class HomeActivity : AppCompatActivity(), HomeActivityFragment.Listener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)
    setSupportActionBar(toolbar)
  }

  override fun onErrorFetchingMovies(message: String) {
    alert(message)
  }
}
