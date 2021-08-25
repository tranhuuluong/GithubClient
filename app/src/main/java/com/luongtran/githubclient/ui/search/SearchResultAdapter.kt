package com.luongtran.githubclient.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.luongtran.githubclient.data.model.UserProfile
import com.luongtran.githubclient.databinding.ItemSearchResultBinding
import com.luongtran.githubclient.util.loadCircle

/**
 * Created by LuongTran on 25/08/2021.
 */
class SearchResultAdapter : ListAdapter<UserProfile, SearchResultAdapter.SearchResultVH>(UserProfile.DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultVH {
        val inflater = LayoutInflater.from(parent.context)
        return SearchResultVH(ItemSearchResultBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: SearchResultVH, position: Int) {
        holder.bind(getItem(position))
    }

    class SearchResultVH(private val binding: ItemSearchResultBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserProfile) {
            binding.run {
                tvUserName.isGone = user.name.isNullOrEmpty()
                tvUserBio.isGone = user.bio.isNullOrEmpty()

                ivAvatar.loadCircle(user.avatar)
                tvUserId.text =  user.userId
                tvUserName.text = user.name
                tvUserBio.text = user.bio
            }
        }
    }
}