package com.example.jetpackcomposeapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log.d
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeapp.data.models.User
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme
import com.example.jetpackcomposeapp.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

     private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.Main).launch {
            val users = mainViewModel.getAllUsers()
            setContent {
                MyApp {
                    MyScreen(users = users)

                }
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MyScreen(users : List<User>) {
    LazyColumn(Modifier.fillMaxWidth(), horizontalAlignment = CenterHorizontally) {
        items(items = users) { user ->
            UserItem(user = user) {

            }
        }
    }
}

@Composable
fun UserItem(user : User, itemCallback : (User) -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable {
                itemCallback(user)
            }) {
        Text(text = user.avatar, style = TextStyle(
            color = androidx.compose.ui.graphics.Color.Cyan,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        ))

        Column {
            Text(
                text = "First name :  ${user.firstName}", style = TextStyle(
                    color = androidx.compose.ui.graphics.Color.Green,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ), modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Text(text = "Last name : ${user.lastName}", style = TextStyle(
                color = androidx.compose.ui.graphics.Color.Red,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ), modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp))
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetpackComposeAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}



