package com.example.bostatask.ui.photo

import com.example.bostatask.ui.album.PhotoUiState

data class PhotoViewUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val photos: List<PhotoUiState> = emptyList(),
    val photo : String = ""
)