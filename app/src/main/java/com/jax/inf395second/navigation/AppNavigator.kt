package com.jax.inf395second.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jax.inf395second.presentation.screens.AccountManagementScreen
import com.jax.inf395second.presentation.screens.LoginScreen
import com.jax.inf395second.presentation.screens.UserListScreen
import com.jax.inf395second.presentation.viewmodel.UserViewModel

@Composable
fun AppNavigator(userViewModel: UserViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "login") {
        composable("login") { LoginScreen(navController, userViewModel) }
        composable("account_management") { AccountManagementScreen(navController, userViewModel) }
        composable("user_list") { UserListScreen(navController, userViewModel) }
    }
}
