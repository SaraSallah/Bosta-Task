package com.example.bostatask.ui.profile

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.bostatask.R
import com.example.bostatask.databinding.FragmentProfileBinding
import com.example.bostatask.ui.base.BaseFragment
import com.example.bostatask.utils.collect
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(){
    override val TAG: String =this::class.simpleName.toString()
    override val layoutIdFragment: Int = R.layout.fragment_profile
    override val viewModel: ProfileViewModel by viewModels()

    override fun setup() {
        initiateAdapter()
        collectAction()
    }

    private fun initiateAdapter() {
        val adapter = ProfileAdapter(viewModel)
        binding.albumsRecyclerView.adapter = adapter
    }

    private fun collectAction() {
        collect(viewModel.effect) { effect ->
            effect.getContentIfHandled()?.let { navigateToAlbum(it.albumId) }
        }
    }

    private fun navigateToAlbum(albumId: Int) {
        val action = ProfileFragmentDirections.actionProfileFragmentToAlbumFragment(albumId)
        findNavController().navigate(action)
    }
}