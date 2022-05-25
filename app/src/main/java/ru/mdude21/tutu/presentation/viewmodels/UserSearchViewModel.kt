package ru.mdude21.tutu.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.mdude21.tutu.domain.models.UsersItem
import ru.mdude21.tutu.domain.repository.UsersInfoRepository
import ru.mdude21.tutu.domain.use_cases.GetUserList
import javax.inject.Inject

@HiltViewModel
class UserSearchViewModel @Inject constructor(
    private val getUserList: GetUserList
) : ViewModel() {

    private val isLoadLiveData = MutableLiveData(false)

    val isLoad: LiveData<Boolean>
        get() = isLoadLiveData

    private val usersListLiveData = MutableLiveData<List<UsersItem>>(emptyList())

    val usersList: LiveData<List<UsersItem>>
        get() = usersListLiveData

    private var searchJob: Job? = null

    fun getUsersListByLogin(login: String) {
        isLoadLiveData.postValue(true)
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            runCatching {
                getUserList.execute(user = login)
            }.onSuccess {
                isLoadLiveData.postValue(false)
                usersListLiveData.postValue(it)
            }.onFailure {
                isLoadLiveData.postValue(false)
                usersListLiveData.postValue(emptyList())
            }
        }
    }
}
