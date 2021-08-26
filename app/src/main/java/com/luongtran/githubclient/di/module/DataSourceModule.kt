package com.luongtran.githubclient.di.module

import com.luongtran.githubclient.data.source.SearchDataSource
import com.luongtran.githubclient.data.source.UserInfoDataSource
import com.luongtran.githubclient.data.source.local.UserInfoLocalDataSource
import com.luongtran.githubclient.data.source.network.SearchRemoteDataSource
import com.luongtran.githubclient.data.source.network.UserInfoRemoteDataSource
import com.luongtran.githubclient.di.qualifier.Local
import com.luongtran.githubclient.di.qualifier.Remote
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by LuongTran on 25/08/2021.
 */
@Module
abstract class DataSourceModule {
    @Binds
    @Singleton
    @Local
    abstract fun providesUserInfoLocalDataSource(dataSource: UserInfoLocalDataSource): UserInfoDataSource

    @Binds
    @Singleton
    @Remote
    abstract fun providesUserInfoRemoteDataSource(dataSource: UserInfoRemoteDataSource): UserInfoDataSource

    @Binds
    @Singleton
    @Remote
    abstract fun providesSearchRemoteDataSource(dataSource: SearchRemoteDataSource): SearchDataSource
}