package com.example.hw2.network

import com.example.hw2.network.model.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface BeerService {
    @GET("v2/beers")
    suspend fun getBeer(@Query("page") page: Int, @Query("per_page") maxResults: Int): Response<List<Data>>
}
