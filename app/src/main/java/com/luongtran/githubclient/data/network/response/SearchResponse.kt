package com.luongtran.githubclient.data.network.response

import com.google.gson.annotations.SerializedName

/**
 * Created by LuongTran on 24/08/2021.
 */
data class SearchResponse(
    @SerializedName("items")
    val results: List<UserBasicInformationResponse>? = null
)