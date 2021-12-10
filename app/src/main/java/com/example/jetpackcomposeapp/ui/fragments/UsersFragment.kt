package com.example.jetpackcomposeapp.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.jetpackcomposeapp.data.models.User
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme
import com.example.jetpackcomposeapp.vm.MainViewModel
import com.skydoves.landscapist.glide.GlideImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UsersFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MyApp {
                    MyScreen(mainViewModel = mainViewModel)
                }
            }
        }
    }

    private fun navigateToUserDetails(userId: Int) {
        val direction = UsersFragmentDirections.actionUsersFragmentToUserDetailsFragment()
        direction.userId = userId
        findNavController().navigate(direction)
    }

    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    fun MyScreen(mainViewModel: MainViewModel) {
        CoroutineScope(Dispatchers.Main).launch {
            mainViewModel.getAllUsers()
        }

        LazyColumn(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            items(items = mainViewModel.users.value) { user ->
                UserItem(user = user)
            }
        }
    }

    @Composable
    fun UserItem(user: User) {
        Row(
            Modifier
                .fillMaxWidth()
                .clickable {
                    navigateToUserDetails(user.id!!)
                }) {
            GlideImage(imageModel = user.avatar,
            Modifier.width(200.dp)
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


    @Composable
    fun MyApp(content: @Composable () -> Unit) {
        JetpackComposeAppTheme {
            // A surface container using the 'background' color from the theme
            Surface(color = MaterialTheme.colors.background) {
                content()
            }
        }
    }
}

