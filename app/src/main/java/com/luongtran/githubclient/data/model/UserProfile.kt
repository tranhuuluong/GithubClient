package com.luongtran.githubclient.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

/**
 * Created by LuongTran on 25/08/2021.
 */
@Parcelize
data class UserProfile(
    val userId: String,
    val avatar: String?,
    val name: String?,
    val company: String?,
    val location: String?,
    val email: String?,
    val bio: String?,
    val blog: String?,
    val repos: Int?,
    val followers: Int?,
    val following: Int?
) : Parcelable {
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