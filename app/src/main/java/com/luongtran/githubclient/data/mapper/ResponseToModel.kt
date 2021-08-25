package com.luongtran.githubclient.data.mapper

import com.luongtran.githubclient.data.model.GithubRepository
import com.luongtran.githubclient.data.model.UserProfile
import com.luongtran.githubclient.data.network.response.GithubRepositoryResponse
import com.luongtran.githubclient.data.network.response.UserProfileResponse

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

fun GithubRepositoryResponse.toGithubRepository() = GithubRepository(name, description, language, stars ?: 0)