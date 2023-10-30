package com.example.bostatask.data.source.remote.network

import com.example.bostatask.data.source.remote.model.albums.AlbumDto
import com.example.bostatask.data.source.remote.model.albums.AlbumsDto
import com.example.bostatask.data.source.remote.model.photos.PhotosDto
import com.example.bostatask.data.source.remote.model.user.UserDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/users/{UserId}")
    suspend fun getUserById(@Path("UserId") userId: String): Response<UserDto>

    @GET("/albums")
    suspend fun getAlbumByUserId(@Query("userId") userId: String): Response<List<AlbumDto>>

    @GET("/photos")
    suspend fun getPhotoByAlbumId(@Query("albumId") albumId: String): Response<PhotosDto>

    @GET("photos")
    suspend fun searchForPhoto(@Query("title") photoId: String): Response<PhotosDto>
}