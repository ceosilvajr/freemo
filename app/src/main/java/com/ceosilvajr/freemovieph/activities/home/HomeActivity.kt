package com.ceosilvajr.freemovieph.activities.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ceosilvajr.freemovieph.R
import kotlinx.android.synthetic.main.activity_home.*

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
class HomeActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)
    setSupportActionBar(toolbar)
  }

}
