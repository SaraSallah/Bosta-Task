package com.example.bostatask.data.remote.model.user


import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("address")
    val address: AddressDto? = null,
    @SerializedName("company")
    val company: CompanyDto? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("username")
    val username: String? = null,
    @SerializedName("website")
    val website: String? = null
)