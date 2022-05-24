package ru.mdude21.tutu.domain.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Users<T>(
    val items: List<T>
)