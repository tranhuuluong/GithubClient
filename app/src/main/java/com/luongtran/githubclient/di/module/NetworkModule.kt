package com.luongtran.githubclient.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.luongtran.githubclient.data.source.network.GithubService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by LuongTran on 24/08/2021.
 */
@Module
object NetworkModule {
    @Provides
    @Singleton
    fun providesGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun providesOkhttpClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
    }

    @Provides
    @Singleton
    fun providesOkhttpClient(builder: OkHttpClient.Builder): OkHttpClient = builder.build()

    @Provides
    @Singleton
    fun providesRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.github.com/")
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesGithubService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }
}