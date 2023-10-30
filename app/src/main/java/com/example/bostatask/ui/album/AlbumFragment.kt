package com.example.bostatask.ui.album

import androidx.fragment.app.viewModels
import com.example.bostatask.R
import com.example.bostatask.databinding.FragmentAlbumBinding
import com.example.bostatask.ui.base.BaseFragment
import com.example.bostatask.ui.profile.ProfileAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumFragment : BaseFragment<FragmentAlbumBinding>() {
    override val TAG: String = this::class.simpleName.toString()
    override val layoutIdFragment: Int = R.layout.fragment_album
    override val viewModel: AlbumViewModel by viewModels()

    override fun setup() {
        initiateAdapter()

    }
    private fun initiateAdapter() {
        val adapter = AlbumAdapter(viewModel)
        binding.rvPhotos.adapter = adapter
    }

}