package dev.amal.feature_basket.data.remote

import dev.amal.feature_basket.data.remote.dto.BasketDto
import retrofit2.http.GET

interface BasketApi {

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getBasket(): BasketDto
}