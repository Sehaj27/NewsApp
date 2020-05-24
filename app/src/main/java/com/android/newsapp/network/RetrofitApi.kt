package com.android.newsapp.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitApi {

    private const val BASE_URL = "https://newsapi.org/"
    const val NEWS_API_KEY = "f3d258542f274c0caf2ea349769b3fca"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
       // .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BASE_URL).build()

    val newsDataService: NewsDataService by lazy {
        retrofit.create(NewsDataService::class.java)
    }

}