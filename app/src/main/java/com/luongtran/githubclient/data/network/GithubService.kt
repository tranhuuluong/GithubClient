package com.luongtran.githubclient.data.network

import com.luongtran.githubclient.data.network.response.SearchResponse
import com.luongtran.githubclient.data.network.response.UserProfileResponse
import com.luongtran.githubclient.data.network.response.UserRepositoryInfoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

/**
 * Created by LuongTran on 24/08/2021.
 */
interface GithubService {
    @GET("search/users")
    suspend fun searchUsers(@QueryMap(encoded = true) queries: Map<String, String>): SearchResponse

    @GET("users/{userId}")
    suspend fun getUserProfile(@Path("userId") userId: String): UserProfileResponse

    @GET("users/{userId}/repos?sort=updated")
    suspend fun getMostRecentUpdatedRepositories(@Path("userId") userId: String, @Query("per_page") pageSize: Int): List<UserRepositoryInfoResponse>
}