package com.luongtran.githubclient.di.module

import com.luongtran.githubclient.di.scope.FragmentScope
import com.luongtran.githubclient.ui.search.SearchFragment
import com.luongtran.githubclient.ui.userprofile.UserProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by LuongTran on 24/08/2021.
 */
@Module
abstract class ActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun searchFragment(): SearchFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun userProfileFragment(): UserProfileFragment
}