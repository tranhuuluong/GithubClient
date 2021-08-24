package com.luongtran.hometest.di.module

import com.luongtran.hometest.di.scope.FragmentScope
import com.luongtran.hometest.search.SearchFragment
import com.luongtran.hometest.userprofile.UserProfileFragment
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