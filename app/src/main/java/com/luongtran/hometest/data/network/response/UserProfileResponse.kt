package com.luongtran.hometest.data.network.response

import com.google.gson.annotations.SerializedName

/**
 * Created by LuongTran on 24/08/2021.
 */
data class UserProfileResponse(
    @SerializedName("login")
    val userId: String,
    @SerializedName("avatar_url")
    val avatar: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("company")
    val company: String? = null,
    @SerializedName("location")
    val location: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("bio")
    val bio: String? = null,
    @SerializedName("public_repos")
    val repos: Int? = null,
    @SerializedName("followers")
    val followers: Int? = null,
    @SerializedName("following")
    val following: Int? = null,
)