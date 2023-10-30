package com.example.bostatask.data.utils

sealed class UiState<out T> {
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
    object Loadding : UiState<Nothing>()

    fun toData(): T? = if (this is Success) data else null
}
