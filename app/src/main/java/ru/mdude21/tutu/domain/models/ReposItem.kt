package ru.mdude21.tutu.domain.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReposItem(
    val id: Int,
    val language: String?,
    val name: String?,
    val updated_at: String?,
)