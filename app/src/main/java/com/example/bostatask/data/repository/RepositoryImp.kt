package com.example.bostatask.data.repository

import android.util.Log.e
import com.example.bostatask.data.source.remote.mapper.toAlbum
import com.example.bostatask.data.source.remote.mapper.toPhoto
import com.example.bostatask.data.source.remote.mapper.toPhotos
import com.example.bostatask.data.source.remote.mapper.toUser
import com.example.bostatask.data.source.remote.network.ApiService
import com.example.bostatask.domain.model.albums.Album
import com.example.bostatask.domain.model.photos.Photo
import com.example.bostatask.domain.model.photos.Photos
import com.example.bostatask.domain.model.user.User
import com.example.bostatask.domain.repository.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val apiService: ApiService,
) : Repository {
    override suspend fun getUserById(userId: String): User =
        wrap { apiService.getUserById(userId) }.toUser()

    override suspend fun getAlbumByUserId(userId: String): List<Album> =
        wrap { apiService.getAlbumByUserId(userId) }.map { it.toAlbum() }

    override suspend fun getPhotoByAlbumId(albumId: String): List<Photo> =
        wrap { apiService.getPhotoByAlbumId(albumId) }.map { it.toPhoto() }

    //
    override suspend fun searchForPhoto(photoId: String): Photos =
        wrap { apiService.searchForPhoto(photoId) }.toPhotos()
}
private suspend fun <T : Any> wrap(function: suspend () -> Response<T>): T {
    val response = function()
    return if (response.isSuccessful) {
        response.body() ?: throw Throwable("Response body is null")
    } else {
        e("TAG", "wrap: ${response}")
        throw Throwable("Request failed with status code ${response.code()}")
    }
}