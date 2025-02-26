package com.jax.inf395second.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jax.inf395second.presentation.viewmodel.UserViewModel

@Composable
fun AccountManagementScreen(navController: NavHostController, userViewModel: UserViewModel) {
    var newUsername by remember { mutableStateOf(TextFieldValue()) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Modify/Delete Account", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (userViewModel.userList.isNotEmpty()) {
                userViewModel.removeUser(userViewModel.userList.last())
            }
        }) {
            Text("Delete Account")
        }
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(value = newUsername, onValueChange = { newUsername = it }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            if (userViewModel.userList.isNotEmpty() && newUsername.text.isNotBlank()) {
                userViewModel.modifyUser(userViewModel.userList.last(), newUsername.text)
            }
        }) {
            Text("Modify Account")
        }
    }
}