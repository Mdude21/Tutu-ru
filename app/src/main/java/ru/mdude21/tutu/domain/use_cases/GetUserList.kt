package ru.mdude21.tutu.domain.use_cases

import ru.mdude21.tutu.domain.models.UsersItem
import ru.mdude21.tutu.domain.repository.UsersInfoRepository

class GetUserList(
    private val repository: UsersInfoRepository
) {
    suspend fun execute(user: String): List<UsersItem> {
        return repository.getListUsers(user)
    }
}