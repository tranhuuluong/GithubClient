package com.luongtran.githubclient.data.mapper

import com.luongtran.githubclient.data.model.UserProfile
import com.luongtran.githubclient.data.model.UserRepositoryInfo
import com.luongtran.githubclient.data.source.network.response.UserProfileResponse
import com.luongtran.githubclient.data.source.network.response.UserRepositoryInfoResponse

/**
 * Created by LuongTran on 25/08/2021.
 */
fun UserProfileResponse.toUserProfile() = UserProfile(
    userId = userId,
    avatar = avatar,
    name = name,
    company = company,
    location = location,
    email = email,
    bio = bio,
    blog = blog,
    repos = repos,
    followers = followers,
    following = following
)

fun UserRepositoryInfoResponse.toUserRepositoryInfo() = UserRepositoryInfo(
    id = id,
    name = name,
    description = description,
    language = language,
    stars = stars ?: 0,
    ownerId = owner.login,
    ownerAvatar = owner.avatar
)