package com.luongtran.githubclient.data.network.response

import com.google.gson.annotations.SerializedName

/**
 * Created by LuongTran on 25/08/2021.
 */
data class GithubRepositoryResponse(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("stargazers_count")
    val stars: Int? = null,
)