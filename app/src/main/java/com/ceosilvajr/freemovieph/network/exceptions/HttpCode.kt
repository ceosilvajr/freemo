package com.ceosilvajr.freemovieph.network.exceptions

/**
Created date 12/10/2018
@author ceosilvajr@gmail.com
 **/
enum class HttpCode(val value: Int) {
  UN_AUTHORIZED(404), SERVICE_UNAVAILABLE(500)
}