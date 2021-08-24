package com.luongtran.hometest.data

import com.luongtran.hometest.data.network.GithubService
import com.luongtran.hometest.data.network.response.SearchResponse
import com.luongtran.hometest.data.network.response.UserProfileResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by LuongTran on 24/08/2021.
 */
@Singleton
class SearchRepository @Inject constructor(
    private val githubService: GithubService
) {

    suspend fun searchUsers(
        keyword: String,
        page: Int,
        pageSize: Int = DEFAULT_PAGE_SIZE
    ): List<UserProfileResponse> = coroutineScope {
        val queries = mapOf(
            "q" to keyword,
            "page" to "$page",
            "per_page" to "$pageSize"
        )

        val results = githubService.searchUsers(queries).results
        results?.map { response ->
            async(Dispatchers.Default) {
                githubService.getUserProfile(response.login)
            }
        }?.awaitAll() ?: emptyList()
    }

    companion object {
        const val DEFAULT_PAGE_SIZE = 10
    }
}