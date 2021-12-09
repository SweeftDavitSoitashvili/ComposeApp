package com.example.jetpackcomposeapp.data.models

import com.google.gson.annotations.SerializedName

data class AllUser(
    @SerializedName("data")
    val users : List<User>
    )

data class SingleUser(
    @SerializedName("data")
    val user : User
    )

data class User(val id : Int,
                val email : String,
                @SerializedName("first_name")
                val firstName : String,
                @SerializedName("last_name")
                val lastName : String,
                val avatar : String
)