package com.example.bostatask.domain.model.user

import com.example.bostatask.data.remote.model.user.GeoDto

data class Address(
    val city: String,
    val geo: GeoDto?,
    val street: String,
    val suite: String,
    val zipCode: String,
)
