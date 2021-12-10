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

data class User(val id : Int? = null,
                val email : String? = null,
                @SerializedName("first_name")
                val firstName : String? = null,
                @SerializedName("last_name")
                val lastName : String? = null,
                val avatar : String? = null
)