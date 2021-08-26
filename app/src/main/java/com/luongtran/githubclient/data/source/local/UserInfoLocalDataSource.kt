package com.luongtran.githubclient.data.source.local

import com.luongtran.githubclient.data.model.UserRepositoryInfo
import com.luongtran.githubclient.data.source.UserInfoDataSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by LuongTran on 25/08/2021.
 */
@Singleton
class UserInfoLocalDataSource @Inject constructor() : UserInfoDataSource {
    override suspend fun getUserMostRecentRepositories(
        userId: String,
        pageSize: Int
    ): List<UserRepositoryInfo> {
        return emptyList()
    }
}