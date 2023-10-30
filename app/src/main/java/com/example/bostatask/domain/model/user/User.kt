package com.example.bostatask.domain.model.user

data class User (
    val address: Address,
    val company : Company,
    val email: String,
    val id :  Int,
    val name : String,
    val phone : String,
    val userName : String,
    val website : String,
)