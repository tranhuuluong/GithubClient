package com.luongtran.githubclient.di.module

import androidx.lifecycle.ViewModel
import com.luongtran.githubclient.di.ViewModelKey
import com.luongtran.githubclient.ui.search.SearchViewModel
import com.luongtran.githubclient.ui.userprofile.UserProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by LuongTran on 24/08/2021.
 */
@Module
abstract class FragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindsSearchViewModel(viewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserProfileViewModel::class)
    abstract fun bindsUserProfileViewModel(viewModel: UserProfileViewModel): ViewModel
}