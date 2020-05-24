package com.android.newsapp.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsDataService {

    @GET("v2/top-headlines?country=in")
    fun fetchNewsFromServer(@Query("apikey") apiKey:String): Single<String>

}