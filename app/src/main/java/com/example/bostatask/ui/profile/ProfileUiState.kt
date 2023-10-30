package com.example.bostatask.ui.profile

import com.example.bostatask.domain.model.albums.Album
import com.example.bostatask.domain.model.user.Address
import com.example.bostatask.domain.model.user.Company
import com.example.bostatask.domain.model.user.Geo
import com.example.bostatask.domain.model.user.User

data class ProfileUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val user: UserUiState = UserUiState(),
    val albums: List<AlbumUiState> = emptyList(),
)

data class UserUiState(
    val address: Address = Address("",
        Geo("", ""), "", "", "")
    ,
    val company: Company = Company(" ", "", ""),
    val email: String = "",
    val id: Int = 0,
    val name: String = "",
    val phone: String = "",
    val userName: String = "",
    val website: String = "",
)

data class AlbumUiState(
    val id: Int = 0,
    val title: String = "",
    val userId: Int = 0,
)

fun User.toUserUiState(): UserUiState {
    return UserUiState(
        address = address,
        company = company,
        email = email,
        id = id,
        name = name,
        phone = phone,
        userName = userName,
        website = website
    )
}


fun List<Album>.toAlbumUiState():List<AlbumUiState>{
    return map{
        AlbumUiState(
            id = it.id ,
            title = it.title ,
            userId = it.id
        )
    }
}