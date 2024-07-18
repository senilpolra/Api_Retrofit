package com.example.api_retrofit

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {
    @GET("todos/1")
    fun getdata(): Call<responceDataClass>
}