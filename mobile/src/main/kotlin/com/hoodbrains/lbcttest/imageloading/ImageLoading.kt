package com.hoodbrains.lbcttest.imageloading

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders


// Simple facade to avoid having a third party symbol all over Ui code

internal fun ImageView.load(url: String) =
    Glide.with(this.context).load(createGlideUrl(url)).into(this)


// Workaround cause placeholder.co filters mobile user agents
// This could be an issue.
fun createGlideUrl(url: String) =
    GlideUrl(url, LazyHeaders.Builder()
        .addHeader("User-Agent", "lbc-test-app")
        .build()
)


internal fun ImageView.clearLoadings() =
    Glide.with(this).clear(this)

