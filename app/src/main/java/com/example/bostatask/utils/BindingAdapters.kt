package com.example.bostatask.utils

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bostatask.R
import com.example.bostatask.ui.album.AlbumViewModel
import com.google.android.material.textfield.TextInputEditText
import org.the_chance.ui.BaseAdapter

@BindingAdapter("app:showIfTrue")
fun showIfTrue(view: View, condition: Boolean) {
    view.isVisible = condition
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    (view.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
}

@BindingAdapter("app:loadImage")
fun bindImage(image: ImageView, imageURL: String?) {
    imageURL?.let {
        Glide.with(image)
            .load(imageURL)
            .placeholder(R.drawable.ic_launcher_background)
            .into(image)
    }
}
@BindingAdapter("app:search")
fun bindTextWatcher(editText: TextInputEditText, viewModel: AlbumViewModel) {
    val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            viewModel.searchPhotoByTitle(s.toString())
        }

        override fun afterTextChanged(s: Editable?) {
        }
    }

    editText.addTextChangedListener(textWatcher)
}

//@BindingAdapter(value = ["app:imageUrl"])
//fun setImageFromUrl(view: ImageView, url: String?) {
//    url?.let {
//        Glide
//            .with(view)
//            .load(url)
//            .centerCrop().into(view)
//
//    }
//}