package com.febrian.coroutineretrofit

import retrofit2.http.GET

interface ApiService {

    @GET("api/recipes")
    suspend fun getRecipe() : Response
}