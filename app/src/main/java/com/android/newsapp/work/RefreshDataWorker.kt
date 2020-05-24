package com.android.newsapp.work

import android.content.Context
import androidx.work.RxWorker
import androidx.work.WorkerParameters
import com.android.newsapp.database.NewsDatabase
import com.android.newsapp.repository.NewsRepository
import io.reactivex.Single

class RefreshDataWorker(appContext: Context, params: WorkerParameters) : RxWorker(appContext, params) {

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    override fun createWork(): Single<Result> {
        return NewsRepository(NewsDatabase.getInstance(applicationContext)).getNewsService()
            .map { Result.success() }
            .onErrorReturn { Result.failure() }
    }
}
