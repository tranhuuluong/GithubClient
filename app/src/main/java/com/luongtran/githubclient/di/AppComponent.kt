package com.luongtran.githubclient.di

import com.luongtran.githubclient.MyApplication
import com.luongtran.githubclient.di.module.AppModule
import com.luongtran.githubclient.di.module.NetworkModule
import com.luongtran.githubclient.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by LuongTran on 24/08/2021.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: MyApplication): AppComponent
    }
}