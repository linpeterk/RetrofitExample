package com.example.retrofitexample.network.repository

import com.example.retrofitexample.network.Login
import com.example.retrofitexample.network.Token
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPIService {

    @POST("auth")
    suspend fun getLogin(@Body login: Login): Response<Token>


}