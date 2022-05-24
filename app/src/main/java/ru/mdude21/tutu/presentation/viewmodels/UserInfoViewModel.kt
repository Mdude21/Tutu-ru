package ru.mdude21.tutu.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.mdude21.tutu.domain.models.User
import ru.mdude21.tutu.domain.repository.UsersInfoRepository
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    private val repository: UsersInfoRepository
) : ViewModel() {

    private val userLiveData = MutableLiveData<User>()

    val user : LiveData<User>
        get() = userLiveData

    private var job: Job? = null

    fun getUserByLogin(login: String) {
        job?.cancel()
        job = viewModelScope.launch {
            runCatching {
                repository.getUserByLogin(login)
            }.onSuccess {
                userLiveData.postValue(it)
            }.onFailure {

            }
        }
    }
}