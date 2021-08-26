package com.luongtran.githubclient.data.source.network.response

import com.google.gson.annotations.SerializedName

/**
 * Created by LuongTran on 25/08/2021.
 */
data class UserRepositoryInfoResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("stargazers_count")
    val stars: Int? = null,
    @SerializedName("owner")
    val owner: UserBasicInformationResponse,
)