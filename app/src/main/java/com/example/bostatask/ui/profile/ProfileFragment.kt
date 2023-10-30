package com.example.bostatask.ui.profile

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.bostatask.R
import com.example.bostatask.databinding.FragmentProfileBinding
import com.example.bostatask.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(){
    override val TAG: String =this::class.simpleName.toString()
    override val layoutIdFragment: Int = R.layout.fragment_profile
    override val viewModel: ProfileViewModel by viewModels()

    override fun setup() {
        initiateAdapter()
    }

    private fun initiateAdapter(){
        val adapter = ProfileAdapter(viewModel)
        binding.albumsRecyclerView.adapter = adapter
    }
}