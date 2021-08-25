package com.luongtran.githubclient.data

import com.luongtran.githubclient.data.model.UserProfile

/**
 * Created by LuongTran on 25/08/2021.
 */
interface SearchDataSource {
    suspend fun searchUsers(keyword: String, page: Int, pageSize: Int): List<UserProfile>
}