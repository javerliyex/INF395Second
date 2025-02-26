package com.jax.inf395second.presentation.screens
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jax.inf395second.presentation.viewmodel.UserViewModel


@Composable
fun UserListScreen(navController: NavHostController, userViewModel: UserViewModel) {
    val users = userViewModel.userList

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Registered Users", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        users.forEach { user ->
            Text(
                user,
                modifier = Modifier.clickable {
                    userViewModel.removeUser(user)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
