package com.luongtran.hometest.data.network

import com.luongtran.hometest.data.network.response.SearchResponse
import com.luongtran.hometest.data.network.response.UserProfileResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * Created by LuongTran on 24/08/2021.
 */
interface GithubService {
    @GET("search/users")
    suspend fun searchUsers(@QueryMap(encoded = true) queries: Map<String, String>): SearchResponse

    @GET("users/{userId}")
    suspend fun getUserProfile(@Path("userId") userId: String): UserProfileResponse
}