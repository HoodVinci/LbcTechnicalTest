package com.hoodbrains.lbcttest.imageloading

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds


// Simple facade to avoid having a third party symbol all over Ui code

internal fun ImageView.load(
    url: String,
    placeholder: Drawable = ColorDrawable(Color.CYAN),
    crossFadeInMs: Duration = 200.milliseconds
) = Glide.with(this.context)
    .load(createGlideUrl(url))
    .placeholder(placeholder)
    .transition(DrawableTransitionOptions.withCrossFade(crossFadeInMs.inWholeMilliseconds.toInt()))
    .into(this)


// Workaround cause placeholder.co filters mobile user agents
// This could be an issue.
fun createGlideUrl(url: String) =
    GlideUrl(
        url, LazyHeaders.Builder()
            .addHeader("User-Agent", "lbc-test-app")
            .build()
    )


internal fun ImageView.clearLoadings() =
    Glide.with(this).clear(this)

