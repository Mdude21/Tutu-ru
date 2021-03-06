package ru.mdude21.tutu.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.mdude21.tutu.data.remote.GithubApi
import ru.mdude21.tutu.data.repository.UserInfoRepositoryImpl
import ru.mdude21.tutu.domain.repository.UsersInfoRepository
import ru.mdude21.tutu.domain.use_cases.GetReposByLogin
import ru.mdude21.tutu.domain.use_cases.GetUserByLogin
import ru.mdude21.tutu.domain.use_cases.GetUserList
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesGithubApi(): GithubApi {
        return Retrofit.Builder()
            .baseUrl(GithubApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GithubApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserInfoRepository(
        api: GithubApi
    ): UsersInfoRepository {
        return UserInfoRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetUsesListUseCase(repository: UsersInfoRepository): GetUserList {
        return GetUserList(repository)
    }

    @Provides
    @Singleton
    fun provideGetUserByLoginUseCase(repository: UsersInfoRepository): GetUserByLogin {
        return GetUserByLogin(repository)
    }

    @Provides
    @Singleton
    fun provideGetReposByLoginUseCase(repository: UsersInfoRepository): GetReposByLogin {
        return GetReposByLogin(repository)
    }
}