package com.luongtran.githubclient.ui.userprofile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.luongtran.githubclient.data.UserInfoRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by LuongTran on 24/08/2021.
 */
class UserProfileViewModel @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) : ViewModel() {
    private val fetchUserReposFlow = MutableSharedFlow<String>(replay = 1)

    val userRepos = fetchUserReposFlow
        .flatMapLatest { userId -> userInfoRepository.getUserMostRecentRepositories(userId) }
        .asLiveData()

    fun fetchUserRepos(userId: String) {
        viewModelScope.launch {
            fetchUserReposFlow.emit(userId)
        }
    }
}