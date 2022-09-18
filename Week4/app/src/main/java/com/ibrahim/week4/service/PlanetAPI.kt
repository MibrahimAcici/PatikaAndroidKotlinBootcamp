package com.ibrahim.week4.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlanetAPI {

    private val BASE_URL = "https://mars.udacity.com/"
//Retrofit build işlemi
    private val planetApi: PlanetService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PlanetService::class.java)

    fun getPlanetService() = planetApi
}