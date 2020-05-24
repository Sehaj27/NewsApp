package com.android.newsapp.utilities

import com.android.newsapp.model.News
import org.json.JSONObject

class Utils {

    companion object {

        fun parseNewsJson(json: String): List<News> {
            val list = arrayListOf<News>()
            val articles = JSONObject(json).getJSONArray("articles")
            articles.apply {
                for (i in 0 until length()) {
                    getJSONObject(i).apply {
                        list.add(
                            News(
                                getString("url"),
                                getString("title"),
                                getString("description"),
                                getString("urlToImage"),
                                ""
                            )
                        )
                    }
                }
            }
            return list
        }

    }
}