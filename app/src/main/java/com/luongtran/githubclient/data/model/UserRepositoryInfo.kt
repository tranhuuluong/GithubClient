package com.luongtran.githubclient.data.model

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by LuongTran on 25/08/2021.
 */
data class UserRepositoryInfo(
    val id: String,
    val name: String?,
    val description: String?,
    val language: String?,
    val stars: Int = 0,
    val ownerId: String,
    val ownerAvatar: String? = null
) {
    companion object {
        val DIFF_UTIL = object: DiffUtil.ItemCallback<UserRepositoryInfo>() {
            override fun areItemsTheSame(
                oldItem: UserRepositoryInfo,
                newItem: UserRepositoryInfo
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: UserRepositoryInfo,
                newItem: UserRepositoryInfo
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}