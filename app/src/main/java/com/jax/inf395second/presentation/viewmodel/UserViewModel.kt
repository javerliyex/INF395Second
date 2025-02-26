package com.jax.inf395second.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jax.inf395second.data.room.User
import com.jax.inf395second.data.room.UserDao
import kotlinx.coroutines.launch

class UserViewModel(private val userDao: UserDao) : ViewModel() {
    var userList by mutableStateOf(listOf<User>())
        private set

    init {
        viewModelScope.launch {
            userList = userDao.getAllUsers()
        }
    }

    fun addUser(username: String) {
        viewModelScope.launch {
            userDao.insertUser(User(username = username))
            userList = userDao.getAllUsers()
        }
    }

    fun removeUser(user: User) {
        viewModelScope.launch {
            userDao.deleteUser(user)
            userList = userDao.getAllUsers()
        }
    }

    fun modifyUser(oldUser: User, newUsername: String) {
        viewModelScope.launch {
            userDao.deleteUser(oldUser)
            userDao.insertUser(User(username = newUsername))
            userList = userDao.getAllUsers()
        }
    }
}