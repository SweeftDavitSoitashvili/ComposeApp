package com.example.jetpackcomposeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jetpackcomposeapp.ui.screens.UserDetails
import com.example.jetpackcomposeapp.ui.screens.Users
import com.example.jetpackcomposeapp.vm.MainViewModel

/**
 * Created by Davit Soitashvili on 16.12.21
 **/

@Composable
fun SetUpNavigation(navController : NavHostController, mainViewModel : MainViewModel) {
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
