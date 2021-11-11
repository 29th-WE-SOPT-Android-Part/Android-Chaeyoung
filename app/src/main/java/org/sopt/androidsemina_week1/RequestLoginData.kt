package org.sopt.androidsemina_week1

import com.google.gson.annotations.SerializedName

data class RequestLoginData(
    @SerializedName("email")
    val email : String,
    val password : String
)
