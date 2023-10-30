package com.example.bostatask.utils

import androidx.lifecycle.Observer

open class EventHandler<out T>(private val content: T) {
    private var hasBeenHandled = false

    fun getContentIfHandled(): T? {
        return if (hasBeenHandled)
            null
        else {
            hasBeenHandled = true
            content
        }
    }
}


