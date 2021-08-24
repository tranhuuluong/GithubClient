package com.luongtran.hometest.di.module

import com.luongtran.hometest.MainActivity
import com.luongtran.hometest.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by LuongTran on 24/08/2021.
 */
@Module
abstract class AppModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    abstract fun mainActivity(): MainActivity
}