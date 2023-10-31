package com.example.bostatask.ui.album

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.bostatask.R
import com.example.bostatask.databinding.FragmentAlbumBinding
import com.example.bostatask.ui.base.BaseFragment
import com.example.bostatask.utils.collect
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumFragment : BaseFragment<FragmentAlbumBinding>() {
    override val TAG: String = this::class.simpleName.toString()
    override val layoutIdFragment: Int = R.layout.fragment_album
    override val viewModel: AlbumViewModel by viewModels()

    override fun setup() {
        initiateAdapter()
        collectAction()

    }

    private fun initiateAdapter() {
        val adapter = AlbumAdapter(viewModel)
        binding.rvPhotos.adapter = adapter
    }

    private fun collectAction() {
        collect(viewModel.effect) { effect ->
            effect.getContentIfHandled()?.let { navigateToPhoto(it.albumId, it.photoId) }
        }
    }

    private fun navigateToPhoto(albumId: Int, photoId: Int) {
        val action =
            AlbumFragmentDirections.actionAlbumFragmentToPhotoViewFragment(albumId, photoId)
        findNavController().navigate(action)
    }

}