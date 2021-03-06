package com.luongtran.githubclient.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luongtran.githubclient.R
import com.luongtran.githubclient.data.model.Result
import com.luongtran.githubclient.data.model.UserProfile
import com.luongtran.githubclient.data.model.errorOrEmpty
import com.luongtran.githubclient.data.model.successAndNotEmpty
import com.luongtran.githubclient.databinding.FragmentSearchBinding
import com.luongtran.githubclient.ui.BaseFragment
import com.luongtran.githubclient.util.addItemDecoration

/**
 * Created by LuongTran on 24/08/2021.
 */
class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    private val viewModel: SearchViewModel by viewModels {
        viewModelFactory
    }

    private val searchAdapter: SearchResultAdapter by lazy {
        createSearchAdapter()
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

            rvSearchResult.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = searchAdapter
                addItemDecoration(R.drawable.divider, RecyclerView.VERTICAL)
            }
        }
    }

    private fun observeData() {
        viewModel.searchResult.observe(viewLifecycleOwner) { result ->
            binding?.run {
                pbLoading.isVisible = result is Result.Loading
                tvError.isVisible = result.errorOrEmpty()
                rvSearchResult.isVisible = result.successAndNotEmpty()

                if (result is Result.Success) {
                    handleResults(result)
                }

                if (result is Result.Error) {
                    handleError(result)
                }
            }
        }
    }

    private fun createSearchAdapter(): SearchResultAdapter {
        return SearchResultAdapter { openUserProfile(it) }
    }

    private fun handleResults(result: Result.Success<List<UserProfile>>) {
        val users = result.data
        if (users.isEmpty()) {
            displayErrorMessage("No results found")
        } else {
            searchAdapter.submitList(users)
        }
    }

    private fun handleError(result: Result.Error) {
        result.exception.message?.let {
            displayErrorMessage(it)
        }
    }

    private fun displayErrorMessage(message: String) {
        binding?.tvError?.text = message
    }

    private fun openUserProfile(userProfile: UserProfile) {
        val direction = SearchFragmentDirections.openUserProfile(userProfile)
        findNavController().navigate(direction)
    }

    private fun performSearch(keyword: String?) {
        viewModel.search(keyword)
    }
}