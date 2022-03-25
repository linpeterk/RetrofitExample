package com.example.retrofitexample.network

import com.google.gson.annotations.SerializedName

data class Token (

    @SerializedName("auth_token") val auth_token:String

)