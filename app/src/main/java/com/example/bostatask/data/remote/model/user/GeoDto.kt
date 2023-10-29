package com.example.bostatask.data.remote.model.user


import com.google.gson.annotations.SerializedName

data class GeoDto(
    @SerializedName("lat")
    val lat: String? = null,
    @SerializedName("lng")
    val lng: String? = null
)