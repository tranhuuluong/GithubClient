package com.luongtran.githubclient.ui.userprofile

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luongtran.githubclient.R
import com.luongtran.githubclient.data.model.Result
import com.luongtran.githubclient.data.model.UserProfile
import com.luongtran.githubclient.data.model.errorOrEmpty
import com.luongtran.githubclient.data.model.successAndNotEmpty
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

//        setupUI()
        displayUserInfo(arg.user)
        observeData()
    }

    private fun setupUI() {
        binding?.run {
            rvRepositories.apply {
                layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
//                adapter = searchAdapter
                addItemDecoration(R.drawable.divider, RecyclerView.VERTICAL)
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

                Log.d("debugTag", "$result")
            }
        }
    }
}