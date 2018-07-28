package com.titouan.next.movilenext_lesson3_databinding.utils

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

class BindingAdapters {

    companion object {
        @JvmStatic
        @BindingAdapter("image")
        fun loadImage(imageView: ImageView, url: String) {
            Picasso.get().load(url).into(imageView)
        }
    }
}
