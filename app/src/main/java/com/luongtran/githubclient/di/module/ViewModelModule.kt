package com.luongtran.githubclient.di.module

import androidx.lifecycle.ViewModelProvider
import com.luongtran.githubclient.di.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Created by LuongTran on 24/08/2021.
 */
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}