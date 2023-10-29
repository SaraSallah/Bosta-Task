package com.example.bostatask.data.source.remote.mapper

import com.example.bostatask.data.source.remote.model.photos.PhotoDto
import com.example.bostatask.data.source.remote.model.photos.PhotosDto
import com.example.bostatask.domain.model.photos.Photo
import com.example.bostatask.domain.model.photos.Photos

fun PhotosDto.toPhotos(): Photos =
    Photos(photos = this.map { it.toPhoto() })

fun PhotoDto.toPhoto(): Photo =
    Photo(
        albumId = albumId ?: 0,
        id = id ?: 0,
        thumbnailUrl = thumbnailUrl ?: "",
        title = title ?: "",
        url = url ?: ""

    )
