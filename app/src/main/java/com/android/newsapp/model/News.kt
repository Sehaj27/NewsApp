package com.android.newsapp.model

data class News(
    val url: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val source: String
)