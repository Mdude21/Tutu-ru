package ru.mdude21.tutu.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.mdude21.tutu.domain.models.Users
import ru.mdude21.tutu.domain.models.UsersItem
import ru.mdude21.tutu.tools.Resource

interface UsersInfoRepository {

    suspend fun getListUsers(user : String) : List<UsersItem>
}