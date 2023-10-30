package com.example.bostatask.domain.repository

import com.example.bostatask.domain.model.albums.Album
import com.example.bostatask.domain.model.albums.Albums
import com.example.bostatask.domain.model.photos.Photos
import com.example.bostatask.domain.model.user.User

interface Repository {

    suspend fun getUserById(userId : String ): User
    suspend fun getAlbumByUserId(userId:String):List<Album>
    suspend fun getPhotoByAlbumId(albumId : String):Photos
    suspend fun searchForPhoto(photoId : String):Photos
}