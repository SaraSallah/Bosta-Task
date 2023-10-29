package com.example.bostatask.domain.repository

import com.example.bostatask.data.utils.UiState
import com.example.bostatask.domain.model.albums.Albums
import com.example.bostatask.domain.model.photos.Photos
import com.example.bostatask.domain.model.user.User

interface Repository {

    suspend fun getUserById(userId : String ): UiState<User>
    suspend fun getAlbumByUserId(userId:String):UiState<Albums>
    suspend fun getPhotoByAlbumId(albumId : String):UiState<Photos>
    suspend fun searchForPhoto(photoId : String):UiState<Photos>
}