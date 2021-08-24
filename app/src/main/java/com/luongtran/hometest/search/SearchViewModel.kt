package com.luongtran.hometest.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.luongtran.hometest.data.SearchRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by LuongTran on 24/08/2021.
 */
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {
    private var page = DEFAULT_PAGE

    private val searchFlow = MutableSharedFlow<String?>()

    private val pageFlow = MutableSharedFlow<Int>()

    val searchResult = searchFlow
        .filterNotNull()
        .filter { keyword -> keyword.isNotBlank() }
        .debounce(300)
        .combine(pageFlow) { keyword, page -> keyword to page }
        .distinctUntilChanged()
        .mapLatest { (keyword, currentPage) ->
            searchRepository.searchUsers(keyword, currentPage)
        }
        .asLiveData()

    fun search(keyword: String?) {
        viewModelScope.launch {
            page = DEFAULT_PAGE
            searchFlow.emit(keyword)
            pageFlow.emit(page)
        }
    }

    companion object {
        const val DEFAULT_PAGE = 1
    }
}