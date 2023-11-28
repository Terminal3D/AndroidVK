package com.example.hw2.data

import com.example.hw2.network.BeerService

interface BeerRepository {
    suspend fun getBeer(page: Int, maxResults: Int) : List<Beer>
}

class NetworkBeerRepository(private val beerService: BeerService) : BeerRepository {

    override suspend fun getBeer(page: Int, maxResults: Int): List<Beer> {
        val response = beerService.getBeer(page, maxResults)
        return if (response.isSuccessful) {
            response.body()?.map { apiModel ->
                Beer(
                    name = apiModel.name,
                    linkToPic = apiModel.imageUrl
                )
            } ?: emptyList()
        } else {
            emptyList()
        }
    }


}