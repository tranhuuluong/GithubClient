package com.luongtran.hometest.data.network.response

import com.google.gson.annotations.SerializedName

/**
 * Created by LuongTran on 24/08/2021.
 */
data class SearchResponse(
    @SerializedName("items")
    val results: List<UserSearchResponse>? = null
) {
    data class UserSearchResponse(
        @SerializedName("login")
        val login: String
    )
}