package com.luongtran.githubclient.data

import com.luongtran.githubclient.data.model.Result
import com.luongtran.githubclient.data.model.UserRepositoryInfo
import com.luongtran.githubclient.di.qualifier.Local
import com.luongtran.githubclient.di.qualifier.Remote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by LuongTran on 25/08/2021.
 */
@Singleton
class UserInfoRepository @Inject constructor(
    @Remote private val remoteDataSource: UserInfoDataSource,
    @Local private val localDataSource: UserInfoDataSource
) {
    suspend fun getUserMostRecentRepositories(
        userId: String,
        pageSize: Int = DEFAULT_PAGE_SIZE
    ): Flow<Result<List<UserRepositoryInfo>>> = flow {
        emit(Result.Loading)

        try {
            val response = remoteDataSource.getUserMostRecentRepositories(userId, pageSize)

            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }

    companion object {
        const val DEFAULT_PAGE_SIZE = 5
    }
}