package ru.mdude21.tutu.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.mdude21.tutu.domain.models.Users
import ru.mdude21.tutu.domain.models.UsersItem

interface GithubApi {
    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") query: String
    ): Users<UsersItem>

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }
}