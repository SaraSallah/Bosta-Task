package com.example.bostatask.data.remote.model.user


import com.google.gson.annotations.SerializedName

data class AddressDto(
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("geo")
    val geo: GeoDto? = null,
    @SerializedName("street")
    val street: String? = null,
    @SerializedName("suite")
    val suite: String? = null,
    @SerializedName("zipcode")
    val zipcode: String? = null
)