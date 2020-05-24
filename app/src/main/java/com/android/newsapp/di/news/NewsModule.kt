package com.android.newsapp.di.news

import androidx.lifecycle.ViewModel
import com.android.newsapp.di.ViewModelKey
import com.android.newsapp.ui.news.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NewsModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    abstract fun bindViewModel(viewmodel: NewsViewModel): ViewModel
}