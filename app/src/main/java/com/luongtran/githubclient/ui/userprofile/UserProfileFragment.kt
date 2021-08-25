package com.luongtran.githubclient.ui.userprofile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luongtran.githubclient.R
import com.luongtran.githubclient.data.model.*
import com.luongtran.githubclient.databinding.FragmentUserProfileBinding
import com.luongtran.githubclient.ui.BaseFragment
import com.luongtran.githubclient.util.addItemDecoration
import com.luongtran.githubclient.util.loadCircle
import com.luongtran.githubclient.util.setTextOrHide

/**
 * Created by LuongTran on 24/08/2021.
 */
class UserProfileFragment : BaseFragment<FragmentUserProfileBinding>() {

    private val viewModel: UserProfileViewModel by viewModels {
        viewModelFactory
    }

    private val arg: UserProfileFragmentArgs by navArgs()

    private val repositoryAdapter by lazy {
        RepositoryAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchUserRepos(arg.user.userId)
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentUserProfileBinding {
        return FragmentUserProfileBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        displayUserInfo(arg.user)
        observeData()
    }

    private fun setupUI() {
        binding?.run {
            tvBack.setOnClickListener {
                findNavController().navigateUp()
            }

            rvRepositories.apply {
                layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
                adapter = repositoryAdapter
                addItemDecoration(R.drawable.transparent_divider, RecyclerView.HORIZONTAL)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun displayUserInfo(user: UserProfile) {
        binding?.run {
            ivAvatar.loadCircle(user.avatar)
            tvUserName.setTextOrHide(user.name)
            tvUserId.setTextOrHide(user.userId)
            tvUserBio.setTextOrHide(user.bio)
            tvCompany.setTextOrHide(user.company)
            tvLocation.setTextOrHide(user.location)
            tvBlog.setTextOrHide(user.blog)
            tvEmail.setTextOrHide(user.email)
            tvFollowers.setTextOrHide("${user.followers} followers")
            tvFollowing.setTextOrHide("${user.following} following")
        }
    }

    private fun observeData() {
        viewModel.userRepos.observe(viewLifecycleOwner) { result ->
            binding?.run {
                pbLoading.isVisible = result is Result.Loading
                tvError.isVisible = result.errorOrEmpty()
                groupRepositories.isVisible = result.successAndNotEmpty()

                if (result is Result.Success) {
                    handleResult(result.data)
                }

                if (result is Result.Error) {
                    handleError(result)
                }
            }
        }
    }

    private fun handleResult(data: List<UserRepositoryInfo>) {
        if (data.isEmpty()) {
            displayErrorMessage("This user has no activities")
        } else {
            repositoryAdapter.submitList(data)
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
}