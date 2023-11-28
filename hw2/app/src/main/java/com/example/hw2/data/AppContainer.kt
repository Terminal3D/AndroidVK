package com.example.hw2.data

import com.example.hw2.R
import com.example.hw2.network.BeerService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val beerRepository : BeerRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://api.punkapi.com/"



    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val beerService: BeerService by lazy {
        retrofit.create(BeerService::class.java)
    }

    override val beerRepository: BeerRepository by lazy {
        NetworkBeerRepository(beerService)
    }

}