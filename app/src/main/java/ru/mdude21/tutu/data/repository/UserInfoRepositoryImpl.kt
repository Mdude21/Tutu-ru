package ru.mdude21.tutu.data.repository

import ru.mdude21.tutu.data.remote.GithubApi
import ru.mdude21.tutu.domain.models.ReposItem
import ru.mdude21.tutu.domain.models.User
import ru.mdude21.tutu.domain.models.UsersItem
import ru.mdude21.tutu.domain.repository.UsersInfoRepository

class UserInfoRepositoryImpl(private val api: GithubApi) : UsersInfoRepository {
    override suspend fun getListUsers(user: String): List<UsersItem> {
        return api.searchUsers(user).items
    }

    override suspend fun getUserByLogin(login: String): User {
        return api.getInfoUserByLogin(login)
    }

    override suspend fun getReposByLogin(login: String): List<ReposItem> {
        return api.getRepos(login)
    }
}