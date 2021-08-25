package com.luongtran.githubclient.data.model

/**
 * Created by LuongTran on 25/08/2021.
 */
sealed class Result<out T> {
    data class Success<out T>(val data: T): Result<T>()
    data class Error(val exception: Exception): Result<Nothing>()
    object Loading : Result<Nothing>()
}

fun Result<List<*>>.successAndNotEmpty(): Boolean {
    return this is Result.Success && data.isNotEmpty()
}

fun Result<List<*>>.errorOrEmpty(): Boolean {
    return this is Result.Error || (this is Result.Success && data.isEmpty())
}