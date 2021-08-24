package com.luongtran.hometest.userprofile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.luongtran.hometest.BaseFragment
import com.luongtran.hometest.databinding.FragmentUserProfileBinding

/**
 * Created by LuongTran on 24/08/2021.
 */
class UserProfileFragment : BaseFragment<FragmentUserProfileBinding>() {

    private val viewModel: UserProfileViewModel by viewModels {
        viewModelFactory
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

        Log.d("debugTag", "$viewModel")
    }
}