package com.luongtran.hometest.data.mapper

import com.luongtran.hometest.data.model.UserProfile
import com.luongtran.hometest.data.network.response.UserProfileResponse

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
    repos = repos,
    followers = followers,
    following = following
)