package ru.mdude21.tutu.domain.use_cases

import ru.mdude21.tutu.domain.models.User
import ru.mdude21.tutu.domain.repository.UsersInfoRepository

class GetUserByLogin(
    private val repository: UsersInfoRepository
) {
    suspend fun execute(login: String): User {
        return repository.getUserByLogin(login)
    }
}