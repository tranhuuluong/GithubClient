package com.luongtran.githubclient.data.network

import com.luongtran.githubclient.data.SearchDataSource
import com.luongtran.githubclient.data.mapper.toUserProfile
import com.luongtran.githubclient.data.model.UserProfile
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by LuongTran on 25/08/2021.
 */
@Singleton
class SearchRemoteDataSource @Inject constructor(
    private val githubService: GithubService,
    private val ioDispatcher: CoroutineDispatcher
) : SearchDataSource {
    override suspend fun searchUsers(keyword: String, page: Int, pageSize: Int): List<UserProfile> {
        val queries = mapOf(
            "q" to keyword,
            "page" to "$page",
            "per_page" to "$pageSize"
        )

        return withContext(ioDispatcher) {
            val response = githubService.searchUsers(queries)
                .results
                ?.map { response ->
                    async {
                        githubService.getUserProfile(response.login)
                    }
                }?.awaitAll()

            response?.map { it.toUserProfile() } ?: emptyList()
        }
    }
}