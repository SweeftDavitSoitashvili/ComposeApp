package com.example.jetpackcomposeapp.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposeapp.ui.screens.UserDetails
import com.example.jetpackcomposeapp.ui.screens.Users
import com.example.jetpackcomposeapp.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.Users.routeName, builder = {
                
                composable(Routes.Users.routeName) {
                    Users(mainViewModel = mainViewModel, navController = navController)
                }
                composable(Routes.UserDetails.routeName,
                    arguments = listOf(
                    navArgument(USER_ID_KEY) {
                        type = NavType.IntType
                    },)) {
                    val userId = it.arguments?.getInt(USER_ID_KEY)
                    UserDetails(userId = userId!!, mainViewModel = mainViewModel)
                }
            })
        }
    }
}






