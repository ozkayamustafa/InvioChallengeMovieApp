package com.mustafa.inviochallengemovieapp.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter(value = arrayOf("android:urlImage"))
fun urlImage(view:ImageView,url:String?){
    Glide.with(view).load(url).into(view)
}