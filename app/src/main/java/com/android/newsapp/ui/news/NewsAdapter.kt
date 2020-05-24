package com.android.newsapp.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.newsapp.databinding.ListNewsItemViewBinding
import com.android.newsapp.model.News
import com.android.newsapp.ui.ListItemClick


class NewsAdapter(private val onClickListener: ListItemClick) :
    ListAdapter<News, NewsViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.url == newItem.url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(ListNewsItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        holder.binding.learnMoreTextView.setOnClickListener { onClickListener.onClick(news) }
        holder.bind(news)
    }
}

class NewsViewHolder(var binding: ListNewsItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(news: News) {
        binding.news = news
        binding.executePendingBindings()
    }
}