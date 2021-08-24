package com.luongtran.hometest.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
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
        setupUI()
        observeData()
    }

    private fun setupUI() {
        fun EditText.setSearchAction(action: (String?) -> Unit) {
            setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    action.invoke(text?.toString())
                    true
                } else {
                    false
                }
            }
        }

        binding?.run {
            etSearch.setSearchAction { keyword ->
                performSearch(keyword)
            }

            ivClear.setOnClickListener {
                etSearch.text = null
            }
        }
    }

    private fun observeData() {
        viewModel.searchResult.observe(viewLifecycleOwner) {
            Log.d("debugTag", "$it")
        }
    }

    private fun openUserProfile() {
        val direction = SearchFragmentDirections.openUserProfile()
        findNavController().navigate(direction)
    }

    private fun performSearch(keyword: String?) {
        viewModel.search(keyword)
    }
}