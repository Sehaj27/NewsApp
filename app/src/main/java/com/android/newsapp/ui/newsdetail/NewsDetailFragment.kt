package com.android.newsapp.ui.newsdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.android.newsapp.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewsDetailBinding.inflate(inflater)
        binding.apply {
            val url = NewsDetailFragmentArgs.fromBundle(requireArguments()).url
            webview.webViewClient = mWebClient
            val settings = webview.settings
            settings.allowContentAccess = true
            webview.loadUrl(url)
            return root
        }
    }

    private val mWebClient: WebViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return false
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            binding.progress.visibility = View.GONE
        }
    }
}