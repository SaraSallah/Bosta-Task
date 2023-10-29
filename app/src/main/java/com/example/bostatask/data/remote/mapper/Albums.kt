package com.example.bostatask.data.remote.mapper

import com.example.bostatask.data.remote.model.albums.AlbumDto
import com.example.bostatask.data.remote.model.albums.AlbumsDto
import com.example.bostatask.domain.model.albums.Album
import com.example.bostatask.domain.model.albums.Albums

fun AlbumsDto.toAlbums(): Albums =
    Albums(
        album = this.map { it.toAlbum() }
    )

fun AlbumDto.toAlbum(): Album =
    Album(
        id = id ?: 0,
        title = title ?: "",
        userId = userId ?: 0,
        )