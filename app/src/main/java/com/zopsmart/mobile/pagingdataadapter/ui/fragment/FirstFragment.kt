package com.zopsmart.mobile.pagingdataadapter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zopsmart.mobile.pagingdataadapter.databinding.FragmentFirstBinding
import com.zopsmart.mobile.pagingdataadapter.ui.adapter.RedditAdapter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
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
    }

    private fun FragmentFirstBinding.setUpViews() {
        rvPosts.adapter = redditAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


