package com.luongtran.hometest.di.module

import com.luongtran.hometest.di.scope.ActivityScope
import com.luongtran.hometest.ui.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/**
 * Created by LuongTran on 24/08/2021.
 */
@Module
abstract class AppModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    abstract fun mainActivity(): MainActivity

    companion object {
        @Provides
        @Singleton
        fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO
    }
}