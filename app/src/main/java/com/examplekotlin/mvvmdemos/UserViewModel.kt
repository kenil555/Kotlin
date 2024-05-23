package com.examplekotlin.mvvmdemos

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository = UserRepository()
    val users: MutableLiveData<List<User>> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val userList = userRepository.getUsers()
                users.postValue(userList)
            } catch (e: Exception) {
                errorMessage.postValue(e.message)
            }
        }
    }

}
