package com.example.bostatask.data.remote.mapper

import com.example.bostatask.data.remote.model.user.AddressDto
import com.example.bostatask.data.remote.model.user.CompanyDto
import com.example.bostatask.data.remote.model.user.UserDto
import com.example.bostatask.domain.model.user.Address
import com.example.bostatask.domain.model.user.Company
import com.example.bostatask.domain.model.user.User


fun UserDto.toUserModel(): User =
    User(
        address = address!!.toAddress(),
        company = company!!.toCompany(),
        email = email ?: "",
        id = id ?: 0,
        name = name ?: "",
        phone = phone ?: "",
        userName = username ?: "",
        website = website ?: ""
    )

fun AddressDto.toAddress(): Address =
    Address(
        city = city ?: "",
        geo = geo,
        street = street ?: "",
        suite = suite ?: "",
        zipCode = zipcode ?: "",
    )

fun CompanyDto.toCompany(): Company =
    Company(
        bs = bs ?: "",
        catchPhrase = catchPhrase ?: "",
        name = name ?: ""
    )
