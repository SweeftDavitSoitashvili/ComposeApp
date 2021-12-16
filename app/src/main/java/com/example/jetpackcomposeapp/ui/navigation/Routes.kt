package com.example.jetpackcomposeapp.ui.navigation

/**
 * Created by Davit Soitashvili on 16.12.21
 **/

const val USER_ID_KEY = "userId"

sealed class Routes(val routeName : String) {
    object  Users : Routes("User")
    object  UserDetails : Routes("UserDetails/{$USER_ID_KEY}")
}