package ru.mdude21.tutu.domain.repository

import ru.mdude21.tutu.domain.models.User
import ru.mdude21.tutu.domain.models.UsersItem

interface UsersInfoRepository {

    suspend fun getListUsers(user : String) : List<UsersItem>

    suspend fun getUserByLogin(login: String) : User
}