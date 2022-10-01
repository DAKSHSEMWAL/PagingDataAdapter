package com.zopsmart.mobile.pagingdataadapter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.zopsmart.mobile.pagingdataadapter.databinding.FragmentFirstBinding
import com.zopsmart.mobile.pagingdataadapter.ui.adapter.RedditAdapter
import com.zopsmart.mobile.pagingdataadapter.ui.adapter.RedditLoadingAdapter
import com.zopsmart.mobile.pagingdataadapter.ui.viewmodel.RedditViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val redditViewModel: RedditViewModel by lazy {
        ViewModelProvider(this).get(RedditViewModel::class.java)
    }

    private val binding get() = _binding!!

    private val redditAdapter by lazy { RedditAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setUpViews()
        fetchPost()
    }

    private fun FragmentFirstBinding.setUpViews() {
        rvPosts.adapter = redditAdapter.withLoadStateHeaderAndFooter(
            header = RedditLoadingAdapter { redditAdapter.retry() },
            footer = RedditLoadingAdapter { redditAdapter.retry() }
        )
    }

    private fun fetchPost() {
        lifecycleScope.launchWhenCreated {
            lifecycleScope.launch {
                redditViewModel.fetchPosts().collectLatest { pagingData ->
                    redditAdapter.submitData(pagingData)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




