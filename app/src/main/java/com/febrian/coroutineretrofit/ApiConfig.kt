package com.febrian.coroutineretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    fun getService(): ApiService {
        val client = Retrofit.Builder()
            .baseUrl("https://masak-apa.tomorisakura.vercel.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return client.create(ApiService::class.java)
    }
}