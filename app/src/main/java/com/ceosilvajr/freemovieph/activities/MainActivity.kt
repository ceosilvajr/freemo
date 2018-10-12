package com.ceosilvajr.freemovieph.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ceosilvajr.freemovieph.R
import com.ceosilvajr.freemovieph.activities.home.HomeActivity
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    startActivity(intentFor<HomeActivity>().singleTop())
    finish()
  }
}
