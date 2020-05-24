package com.android.newsapp.ui.news

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.android.newsapp.NewsApplication
import com.android.newsapp.databinding.FragmentNewsListBinding
import com.android.newsapp.model.News
import com.android.newsapp.ui.ListItemClick
import javax.inject.Inject

class NewsListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val newsListViewModel: NewsViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as NewsApplication).appComponent.newsComponent().create().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentNewsListBinding.inflate(inflater)
        binding.apply {
            lifecycleOwner = this@NewsListFragment.viewLifecycleOwner
            viewModel = newsListViewModel
            recyclerview.setHasFixedSize(true)
            recyclerview.adapter = NewsAdapter(ListItemClick {
                val url = (it as News).url
              findNavController().navigate(NewsListFragmentDirections.actionNewsListFragmentToNewsDetailFragment(url))
            })
            return root
        }

    }

}