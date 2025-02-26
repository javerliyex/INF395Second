package com.jax.inf395second.apploader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.jax.inf395second.data.room.AppDatabase
import com.jax.inf395second.navigation.AppNavigator
import com.jax.inf395second.presentation.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "user-db").build()
        val userDao = db.userDao()

        setContent {
            val userViewModel = UserViewModel(userDao)
            AppNavigator(userViewModel)
        }
    }
}
