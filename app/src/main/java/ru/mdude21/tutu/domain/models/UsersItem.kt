package ru.mdude21.tutu.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UsersItem(
    @SerializedName("avatar_url")
    val avatar_url: String?,
    @SerializedName("id")
    val id: Long,
    @SerializedName("login")
    val login: String
) : Serializable