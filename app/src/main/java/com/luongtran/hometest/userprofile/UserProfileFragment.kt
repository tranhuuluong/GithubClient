package com.luongtran.hometest.userprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.luongtran.hometest.BaseFragment
import com.luongtran.hometest.databinding.FragmentUserProfileBinding

/**
 * Created by LuongTran on 24/08/2021.
 */
class UserProfileFragment: BaseFragment<FragmentUserProfileBinding>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentUserProfileBinding {
        return FragmentUserProfileBinding.inflate(inflater, container, false)
    }
}