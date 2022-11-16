package dev.amal.feature_home_store.data.remote

import dev.amal.feature_home_store.data.remote.dto.AllProductsDto
import dev.amal.feature_home_store.data.remote.dto.BasketDto
import retrofit2.http.GET

interface AllProductsApi {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getAllProducts(): AllProductsDto

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getBasket(): BasketDto
}