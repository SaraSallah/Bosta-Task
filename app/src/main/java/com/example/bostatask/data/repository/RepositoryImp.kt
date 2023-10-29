package com.example.bostatask.data.repository

import com.example.bostatask.data.source.remote.mapper.toAlbums
import com.example.bostatask.data.source.remote.mapper.toPhotos
import com.example.bostatask.data.source.remote.mapper.toUser
import com.example.bostatask.data.source.remote.network.ApiService
import com.example.bostatask.data.utils.UiState
import com.example.bostatask.domain.model.albums.Albums
import com.example.bostatask.domain.model.photos.Photos
import com.example.bostatask.domain.model.user.User
import com.example.bostatask.domain.repository.Repository
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val apiService: ApiService,
) : Repository {
    override suspend fun getUserById(userId: String): UiState<User> =
          wrap { apiService.getUserById(userId).toUser() }

    override suspend fun getAlbumByUserId(userId: String): UiState<Albums> =
        wrap { apiService.getAlbumByUserId(userId).toAlbums() }

    override suspend fun getPhotoByAlbumId(albumId: String): UiState<Photos> =
        wrap { apiService.getPhotoByAlbumId(albumId).toPhotos() }

    override suspend fun searchForPhoto(photoId: String): UiState<Photos> =
        wrap { apiService.searchForPhoto(photoId).toPhotos() }
}
inline fun <T> wrap(block: () -> T): UiState<T> {
    return try {
        val result = block()
        UiState.Success(result)
    } catch (e: Exception) {
        val errorMessage = e.message ?: "An unknown error occurred"
        UiState.Error(errorMessage)
    }
}