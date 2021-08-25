package com.luongtran.hometest.data

import com.luongtran.hometest.data.mapper.toUserProfile
import com.luongtran.hometest.data.model.Result
import com.luongtran.hometest.data.network.GithubService
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by LuongTran on 24/08/2021.
 */
@Singleton
class SearchRepository @Inject constructor(
    private val githubService: GithubService,
    private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun searchUsers(
        keyword: String,
        page: Int,
        pageSize: Int = DEFAULT_PAGE_SIZE
    ) = flow {
        emit(Result.Loading)

        val queries = mapOf(
            "q" to keyword,
            "page" to "$page",
            "per_page" to "$pageSize"
        )

        coroutineScope {
            try {
                val results = githubService.searchUsers(queries)
                    .results
                    ?.map { response ->
                        async(ioDispatcher + SupervisorJob()) {
                            githubService.getUserProfile(response.login)
                        }
                    }?.awaitAll() ?: emptyList()

                emit(
                    Result.Success(
                        results.map { it.toUserProfile() }
                    )
                )
            } catch (e: Exception) {
                emit(Result.Error(e))
            }
        }
    }

    companion object {
        const val DEFAULT_PAGE_SIZE = 10
    }
}