package com.luongtran.githubclient.data.model

/**
 * Created by LuongTran on 25/08/2021.
 */
sealed class Result<out T> {
    data class Success<out T>(val data: T): Result<T>()
    data class Error(val exception: Exception): Result<Nothing>()
    object Loading : Result<Nothing>()
}
