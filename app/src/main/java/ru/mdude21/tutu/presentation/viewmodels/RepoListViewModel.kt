package ru.mdude21.tutu.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.mdude21.tutu.domain.models.ReposItem
import ru.mdude21.tutu.domain.use_cases.GetReposByLogin
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val getReposByLogin: GetReposByLogin
) : ViewModel() {

    private val reposListLiveData = MutableLiveData<List<ReposItem>>(emptyList())

    val reposList: LiveData<List<ReposItem>>
        get() = reposListLiveData

    private var job: Job? = null

    fun getReposListByLogin(login: String) {

        job?.cancel()

        job = viewModelScope.launch {
            runCatching {
                getReposByLogin.execute(login = login)
            }.onSuccess {
                reposListLiveData.postValue(it)
            }.onFailure {
                reposListLiveData.postValue(emptyList())
            }
        }
    }

}