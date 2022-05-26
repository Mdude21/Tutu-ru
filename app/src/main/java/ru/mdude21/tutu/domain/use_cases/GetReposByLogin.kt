package ru.mdude21.tutu.domain.use_cases

import ru.mdude21.tutu.domain.models.ReposItem
import ru.mdude21.tutu.domain.repository.UsersInfoRepository

class GetReposByLogin(
    private val repository: UsersInfoRepository
) {
    suspend fun execute(login: String): List<ReposItem> {
        return repository.getReposByLogin(login)
    }
}