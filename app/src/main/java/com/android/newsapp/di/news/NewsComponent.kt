package com.android.newsapp.di.news

import com.android.newsapp.ui.news.NewsListFragment
import dagger.Subcomponent

@Subcomponent(modules = [NewsModule::class])
interface NewsComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NewsComponent
    }

    fun inject(fragment: NewsListFragment)
}
