package com.example.jetpackcomposeapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcomposeapp.data.models.User
import com.example.jetpackcomposeapp.vm.MainViewModel
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch

/**
 * Created by Davit Soitashvili on 16.12.21
 **/

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Users(mainViewModel : MainViewModel, navController: NavController) {
    rememberCoroutineScope().launch {
        mainViewModel.getAllUsers()
    }

    LazyColumn {
        items(items = mainViewModel.users.value) {
            UserItem(user = it, navController = navController)
        }
    }
}

@Composable
fun UserItem(user: User, navController: NavController) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("UserDetails/${user.id}")
            }) {
        GlideImage(imageModel = user.avatar,
            Modifier
                .width(200.dp)
                .height(200.dp)
                .clip(CircleShape))

        Column {
            Text(
                text = "First name :  ${user.firstName}", style = TextStyle(
                    color = Color.Green,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ), modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Text(
                text = "Last name : ${user.lastName}", style = TextStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ), modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}