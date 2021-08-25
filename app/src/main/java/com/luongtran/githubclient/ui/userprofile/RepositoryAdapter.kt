package com.luongtran.githubclient.ui.userprofile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.luongtran.githubclient.R
import com.luongtran.githubclient.data.model.UserRepositoryInfo
import com.luongtran.githubclient.databinding.ItemRepositoryBinding
import com.luongtran.githubclient.util.loadCircle
import com.luongtran.githubclient.util.setTextOrHide

/**
 * Created by LuongTran on 25/08/2021.
 */
class RepositoryAdapter : ListAdapter<UserRepositoryInfo, RepositoryAdapter.RepositoryViewHolder>(UserRepositoryInfo.DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RepositoryViewHolder(ItemRepositoryBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RepositoryViewHolder(private val binding: ItemRepositoryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(userRepositoryInfo: UserRepositoryInfo) {
            binding.run {
                ivAvatar.loadCircle(userRepositoryInfo.ownerAvatar)
                tvUserId.text = userRepositoryInfo.ownerId
                tvStars.text = userRepositoryInfo.stars.toString()
                tvRepoName.setTextOrHide(userRepositoryInfo.name)
                tvRepoDescription.setTextOrHide(userRepositoryInfo.description)
                bindLanguageTextView(userRepositoryInfo.language)
            }
        }

        private fun bindLanguageTextView(language: String?) {
            binding.tvLanguage.run {
                setTextOrHide(language)
                language?.let {
                    val drawable = ContextCompat.getDrawable(binding.root.context, R.drawable.circle_indicator)
                    drawable?.setTint(getRandomColor())
                    setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
                }
            }
        }

        private fun getRandomColor(): Int {
            return binding.root.context.resources.getIntArray(R.array.random_color).random()
        }
    }
}