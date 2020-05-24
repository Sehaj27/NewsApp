package com.android.newsapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.android.newsapp.database.NewsDatabase
import com.android.newsapp.database.NewsEntity
import com.android.newsapp.model.News
import com.android.newsapp.network.RetrofitApi
import com.android.newsapp.utilities.Utils
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsRepository @Inject constructor(private val database: NewsDatabase) {

    val news: LiveData<List<News>> = Transformations.map(database.newsDao.getNews()) { dbNewsList ->
        dbNewsList.map {
            News(
                it.url, it.title, it.description, it.imageUrl, it.source
            )
        }
    }

    fun getNewsService(): Single<String> {
        return RetrofitApi.newsDataService.fetchNewsFromServer(RetrofitApi.NEWS_API_KEY)
    }

    fun refreshNews(): Disposable? {
        return getNewsService()
            .subscribeOn(Schedulers.io())
            .map { updateNewsOnDb(Utils.parseNewsJson(it)) }
            .onErrorReturn { return@onErrorReturn null }
            .subscribe()
    }


    private fun updateNewsOnDb(list: List<News>) {
        database.newsDao.insertAll(
            *list.map {
                NewsEntity(
                    it.url, it.title, it.description, it.imageUrl, it.source
                )
            }.toTypedArray()
        )
    }

}