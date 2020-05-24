package com.android.newsapp.di

import android.content.Context
import androidx.room.Room
import com.android.newsapp.database.NewsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideDataBase(context: Context): NewsDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            NewsDatabase::class.java,
            "news_database.db"
        ).build()
    }
}