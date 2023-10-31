package com.example.bostatask.ui.photo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.bostatask.R
import com.example.bostatask.databinding.FragmentPhotoViewBinding
import com.example.bostatask.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoViewFragment :
    BaseFragment<FragmentPhotoViewBinding>() {
    override val TAG: String =this ::class.simpleName.toString()
    override val layoutIdFragment: Int =R.layout.fragment_photo_view
    override val viewModel: PhotoViewModel by viewModels()



}