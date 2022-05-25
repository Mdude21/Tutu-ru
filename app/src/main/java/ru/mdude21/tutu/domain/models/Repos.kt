package ru.mdude21.tutu.domain.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Repos<T>(
    val items: List<T>
)