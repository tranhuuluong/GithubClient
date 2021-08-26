package com.luongtran.githubclient.data.source

import com.luongtran.githubclient.data.model.UserRepositoryInfo

/**
 * Created by LuongTran on 25/08/2021.
 */
interface UserInfoDataSource {
    suspend fun getUserMostRecentRepositories(userId: String, pageSize: Int): List<UserRepositoryInfo>
}