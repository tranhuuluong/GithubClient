package com.luongtran.githubclient.data

import com.luongtran.githubclient.data.model.Result
import com.luongtran.githubclient.di.qualifier.Remote
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by LuongTran on 24/08/2021.
 */
@Singleton
class SearchRepository @Inject constructor(
    @Remote private val searchRemoteDataSource: SearchDataSource
) {

    suspend fun searchUsers(
        keyword: String,
        page: Int,
        pageSize: Int = DEFAULT_PAGE_SIZE
    ) = flow {
        emit(Result.Loading)

        try {
            val result = searchRemoteDataSource.searchUsers(keyword, page, pageSize)

            emit(Result.Success(result))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }

    companion object {
        const val DEFAULT_PAGE_SIZE = 5
    }
}