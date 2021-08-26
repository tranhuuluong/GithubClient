package com.luongtran.githubclient.data.source.network

import com.luongtran.githubclient.data.mapper.toUserRepositoryInfo
import com.luongtran.githubclient.data.model.UserRepositoryInfo
import com.luongtran.githubclient.data.source.UserInfoDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by LuongTran on 25/08/2021.
 */
@Singleton
class UserInfoRemoteDataSource @Inject constructor(
    private val githubService: GithubService,
    private val ioDispatcher: CoroutineDispatcher
) : UserInfoDataSource {

    override suspend fun getUserMostRecentRepositories(
        userId: String,
        pageSize: Int
    ): List<UserRepositoryInfo> {
        return withContext(ioDispatcher) {
            githubService
                .getMostRecentUpdatedRepositories(userId, pageSize)
                .map { it.toUserRepositoryInfo() }
        }
    }
}