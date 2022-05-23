package ru.mdude21.tutu.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Users<T>(
    @SerializedName("users")
    val users: List<T>
) : Serializable