package com.ceosilvajr.freemovieph.network

import com.ceosilvajr.freemovieph.BuildConfig
import com.ceosilvajr.freemovieph.network.exceptions.HttpCode
import com.ceosilvajr.freemovieph.network.exceptions.ServiceUnAvailableException
import com.ceosilvajr.freemovieph.network.exceptions.UnAuthorizeException
import com.ceosilvajr.freemovieph.network.response.FetchMoviesResponse
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap
import java.util.concurrent.TimeUnit

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
interface ApiService {

  @GET("discover/")
  fun getMovies(@QueryMap params: HashMap<String, String>): Flowable<FetchMoviesResponse>

  companion object {
    private const val timeOutInSeconds: Long = 30
    fun create(): ApiService {
      val retrofit = Retrofit.Builder()
          .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
          .addConverterFactory(GsonConverterFactory.create())
          .baseUrl(BuildConfig.BASE_URL)
          .client(OkHttpClient.Builder()
              .addInterceptor(requestHeaderInterceptor())
              .addInterceptor(loggingInterceptor())
              .connectTimeout(timeOutInSeconds, TimeUnit.SECONDS)
              .readTimeout(timeOutInSeconds, TimeUnit.SECONDS)
              .writeTimeout(timeOutInSeconds, TimeUnit.SECONDS)
              .build())
          .build()
      return retrofit.create(ApiService::class.java)
    }

    private fun requestHeaderInterceptor(): Interceptor {
      return Interceptor {
        val request = it.request()
        val response = it.proceed(request)
        when (response.code()) {
          HttpCode.UN_AUTHORIZED.value -> throw UnAuthorizeException()
          HttpCode.SERVICE_UNAVAILABLE.value -> throw ServiceUnAvailableException()
        }
        return@Interceptor response
      }
    }

    private fun loggingInterceptor(): Interceptor {
      val loggingInterceptor = HttpLoggingInterceptor()
      if (BuildConfig.DEBUG) {
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
      }
      return loggingInterceptor
    }
  }
}