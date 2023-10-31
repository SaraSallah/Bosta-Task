package com.example.bostatask.ui.album

import com.example.bostatask.R
import org.the_chance.ui.BaseAdapter
import org.the_chance.ui.BaseInteractionListener

class AlbumAdapter(listener: AlbumInteractionListener) : BaseAdapter<AlbumUiState>(listener) {
    override val layoutID: Int get() = R.layout.item_photo

}

interface AlbumInteractionListener: BaseInteractionListener {
    fun onClickPhoto(photoId: Int)
}