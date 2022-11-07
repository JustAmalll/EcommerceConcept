package dev.amal.ecommerceconcept.data.remote

import dev.amal.ecommerceconcept.data.remote.dto.AllItems
import dev.amal.ecommerceconcept.data.remote.dto.BasketDto
import dev.amal.ecommerceconcept.data.remote.dto.ItemDetailsDto
import retrofit2.http.GET

interface StoreApi {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getAllItems(): AllItems

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getItemDetails(): ItemDetailsDto

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getBasket(): BasketDto
}