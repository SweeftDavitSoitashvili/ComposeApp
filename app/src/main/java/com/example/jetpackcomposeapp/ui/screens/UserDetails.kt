package com.example.jetpackcomposeapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeapp.vm.MainViewModel
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch

/**
 * Created by Davit Soitashvili on 16.12.21
 **/

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun UserDetails(userId: Int, mainViewModel: MainViewModel) {
    rememberCoroutineScope().launch {
        mainViewModel.getUser(userId)
    }

    val user = mainViewModel.user.value
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GlideImage(
            imageModel = user.avatar,
            Modifier
                .width(400.dp)
                .height(400.dp)
                .clip(CircleShape)
        )

        Text(
            text = "First name : ${user.firstName}", style = TextStyle(
                color = Color.Red,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center,
                fontSize = 20.sp

            )
        )

        Text(
            text = "Last name : ${user.lastName}", style = TextStyle(
                color = Color.Green,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )
        )

        Text(
            text = "Email Address : ${user.email}", style = TextStyle(
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 15.sp
            )
        )
    }
}