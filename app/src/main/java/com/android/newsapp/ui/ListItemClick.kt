package com.android.newsapp.ui

class ListItemClick(val clickListener: (o: Any) -> Unit) {
    fun onClick(o: Any) = clickListener(o)
}