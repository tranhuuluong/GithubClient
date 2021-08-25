package com.luongtran.githubclient.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.luongtran.githubclient.data.model.UserProfile
import com.luongtran.githubclient.databinding.ItemSearchResultBinding
import com.luongtran.githubclient.util.loadCircle
import com.luongtran.githubclient.util.setTextOrHide

/**
 * Created by LuongTran on 25/08/2021.
 */
class SearchResultAdapter(private val onItemClickListener: (UserProfile) -> Unit) : ListAdapter<UserProfile, SearchResultAdapter.SearchResultVH>(UserProfile.DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultVH {
        val inflater = LayoutInflater.from(parent.context)
        return SearchResultVH(ItemSearchResultBinding.inflate(inflater, parent, false), onItemClickListener)
    }

    override fun onBindViewHolder(holder: SearchResultVH, position: Int) {
        holder.bind(getItem(position))
    }

    class SearchResultVH(
        private val binding: ItemSearchResultBinding,
        onItemClickListener: (UserProfile) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        private var user: UserProfile? = null

        init {
            binding.root.setOnClickListener {
                user?.let {
                    onItemClickListener.invoke(it)
                }
            }
        }

        fun bind(user: UserProfile) {
            this.user = user

            binding.run {
                ivAvatar.loadCircle(user.avatar)
                tvUserId.text =  user.userId
                tvUserName.setTextOrHide(user.name)
                tvUserBio.setTextOrHide(user.bio)
            }
        }
    }
}