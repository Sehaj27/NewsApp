package com.android.newsapp.di

import com.android.newsapp.di.news.NewsComponent
import dagger.Module


@Module(subcomponents = [NewsComponent::class])
class AppSubComponents