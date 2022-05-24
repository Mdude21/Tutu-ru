package ru.mdude21.tutu.domain.models

import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class UsersItem(
    val avatar_url: String?,
    val id: Long,
    val login: String
) : Serializable