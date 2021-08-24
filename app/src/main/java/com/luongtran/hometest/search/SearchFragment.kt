package com.luongtran.hometest.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.luongtran.hometest.BaseFragment
import com.luongtran.hometest.databinding.FragmentSearchBinding

/**
 * Created by LuongTran on 24/08/2021.
 */
class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    private val viewModel: SearchViewModel by viewModels {
        viewModelFactory
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btOpenUserProfile?.setOnClickListener {
            openUserProfile()
        }

        Log.d("debugTag", "$viewModel")
    }

    private fun openUserProfile() {
        val direction = SearchFragmentDirections.openUserProfile()
        findNavController().navigate(direction)
    }
}