package com.luongtran.githubclient.data.model

/**
 * Created by LuongTran on 25/08/2021.
 */
data class GithubRepository(
    val name: String?,
    val description: String?,
    val language: String?,
    val stars: Int = 0
)