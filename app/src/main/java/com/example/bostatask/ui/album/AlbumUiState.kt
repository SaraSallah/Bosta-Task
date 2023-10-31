package com.example.bostatask.ui.album

import com.example.bostatask.domain.model.albums.Album
import com.example.bostatask.domain.model.photos.Photo
import com.example.bostatask.ui.profile.AlbumUiState

data class AlbumUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val photos: List<PhotoUiState> = emptyList(),
    val searchedPhoto : List<PhotoUiState> = emptyList()
)

data class PhotoUiState(
    val albumId: Int = 0,
    val id: Int = 0,
    val thumbnailUrl: String = "",
    val title: String = "",
    val url: String = "",

    )

fun List<Photo>.toPhotoUiState(): List<PhotoUiState> {
    return map {
        PhotoUiState(
            albumId = it.albumId,
            id = it.id,
            thumbnailUrl = it.thumbnailUrl,
            title = it.title,
            url = it.url
        )
    }
}
