package com.android.newsapp.di

import android.content.Context
import com.android.newsapp.di.news.NewsComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelBuilderModule::class,AppSubComponents::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun newsComponent(): NewsComponent.Factory

}