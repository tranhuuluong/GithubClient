package com.luongtran.githubclient.ui.userprofile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.luongtran.githubclient.data.model.UserProfile
import com.luongtran.githubclient.databinding.FragmentUserProfileBinding
import com.luongtran.githubclient.ui.BaseFragment
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

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentUserProfileBinding {
        return FragmentUserProfileBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayUserInfo(arg.user)
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
}