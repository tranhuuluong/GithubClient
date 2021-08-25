package com.luongtran.hometest.util

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.luongtran.hometest.R

/**
 * Created by LuongTran on 25/08/2021.
 */
private fun createRequestOption(): RequestOptions = RequestOptions()
    .diskCacheStrategy(DiskCacheStrategy.ALL)
    .centerInside()

private fun ImageView.loadWithRequestOption(url: String?, requestOptions: RequestOptions) {
    if (url.isNullOrBlank()) {
        return
    }

    Glide.with(this)
        .load(url)
        .apply(requestOptions)
        .into(this)
}

fun ImageView.load(url: String?) {
    loadWithRequestOption(url, createRequestOption())
}

fun ImageView.loadCircle(url: String?) {
    val requestOptions = createRequestOption().circleCrop()
    loadWithRequestOption(url, requestOptions)
}

fun RecyclerView.addItemDecoration(@DrawableRes drawable: Int, orientation: Int) {
    ResourcesCompat.getDrawable(context.resources, drawable, null)?.let {
        val divider = DividerItemDecoration(context, orientation)
        divider.setDrawable(it)
        addItemDecoration(divider)
    }
}