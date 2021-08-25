package com.luongtran.githubclient.data

import com.luongtran.githubclient.data.mapper.toGithubRepository
import com.luongtran.githubclient.data.model.Result
import com.luongtran.githubclient.data.model.UserRepositoryInfo
import com.luongtran.githubclient.data.network.GithubService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by LuongTran on 25/08/2021.
 */
@Singleton
class UserInfoRepository @Inject constructor(
    private val githubService: GithubService,
    private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun getUserMostRecentRepositories(
        userId: String,
        pageSize: Int = DEFAULT_PAGE_SIZE
    ): Flow<Result<List<UserRepositoryInfo>>> = flow {
        emit(Result.Loading)

        try {
            val response = withContext(ioDispatcher) {
                githubService
                    .getMostRecentUpdatedRepositories(userId, pageSize)
                    .map { it.toGithubRepository() }
            }

            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }

    companion object {
        const val DEFAULT_PAGE_SIZE = 5
    }
}