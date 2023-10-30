package com.example.bostatask.ui.profile

import com.example.bostatask.R
import org.the_chance.ui.BaseAdapter
import org.the_chance.ui.BaseInteractionListener

class ProfileAdapter(listener: ProfileInteractionListener) : BaseAdapter<ProfileUiState>(listener) {
    override val layoutID: Int get() = R.layout.item_album

}

interface ProfileInteractionListener: BaseInteractionListener {
    fun onClickAlbum(albumId: Long)
}