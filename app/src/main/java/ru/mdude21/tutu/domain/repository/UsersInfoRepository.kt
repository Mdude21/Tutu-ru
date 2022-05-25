package ru.mdude21.tutu.domain.repository

import ru.mdude21.tutu.domain.models.ReposItem
import ru.mdude21.tutu.domain.models.User
import ru.mdude21.tutu.domain.models.UsersItem

interface UsersInfoRepository {

    suspend fun getListUsers(user: String): List<UsersItem>

    suspend fun getUserByLogin(login: String): User

    suspend fun getReposByLogin(login: String): List<ReposItem>
}