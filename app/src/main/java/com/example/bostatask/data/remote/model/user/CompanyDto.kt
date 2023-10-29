package com.example.bostatask.data.remote.model.user


import com.google.gson.annotations.SerializedName

data class CompanyDto(
    @SerializedName("bs")
    val bs: String? = null,
    @SerializedName("catchPhrase")
    val catchPhrase: String? = null,
    @SerializedName("name")
    val name: String? = null
)