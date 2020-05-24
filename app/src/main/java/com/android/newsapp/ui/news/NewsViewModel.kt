package com.android.newsapp.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.newsapp.model.News
import com.android.newsapp.repository.NewsRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    private val disposables: CompositeDisposable by lazy { CompositeDisposable() }
    val newsList: LiveData<List<News>> = newsRepository.news

    init {
        refreshNews()
    }

    private fun refreshNews() {
        val disposable = newsRepository.refreshNews()
        if (disposable != null)
            disposables.add(this.disposables)
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }

}