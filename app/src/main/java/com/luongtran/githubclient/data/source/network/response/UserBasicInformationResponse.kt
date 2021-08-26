package com.luongtran.githubclient.data.source.network.response

import com.google.gson.annotations.SerializedName

/**
 * Created by LuongTran on 25/08/2021.
 */
data class UserBasicInformationResponse(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatar: String?
)