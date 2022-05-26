package ru.mdude21.tutu.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.mdude21.tutu.domain.models.*

interface GithubApi {
    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") query: String
    ): Users<UsersItem>

    @GET("users/{login}")
    suspend fun getInfoUserByLogin(
        @Path("login") login: String
    ): User

    @GET("users/{login}/repos")
    suspend fun getRepos(
        @Path("login") login: String
    ): List<ReposItem>

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }
}