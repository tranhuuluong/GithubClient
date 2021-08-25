package com.luongtran.hometest.data.model

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by LuongTran on 25/08/2021.
 */
data class UserProfile(
    val userId: String,
    val avatar: String?,
    val name: String?,
    val company: String?,
    val location: String?,
    val email: String?,
    val bio: String?,
    val repos: Int?,
    val followers: Int?,
    val following: Int?
) {
    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<UserProfile>() {
            override fun areItemsTheSame(oldItem: UserProfile, newItem: UserProfile): Boolean {
                return oldItem.userId == newItem.userId
            }

            override fun areContentsTheSame(oldItem: UserProfile, newItem: UserProfile): Boolean {
                return oldItem == newItem
            }
        }
    }
}