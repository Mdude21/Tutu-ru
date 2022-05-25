package ru.mdude21.tutu.domain.models

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class User(
    val avatar_url: String,
    val email: String?,
    val followers: Int,
    val following: Int,
    val id: Int,
    val login: String,
    val name: String?,
    val public_repos: Int
)