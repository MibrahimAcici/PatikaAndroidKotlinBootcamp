package com.ibrahim.week4.service

import com.ibrahim.week4.model.PlanetListItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlanetService {

    @GET("realestate")
    fun getPlanet(@Query("") apiKey:String) : Call<List<PlanetListItem>>

}